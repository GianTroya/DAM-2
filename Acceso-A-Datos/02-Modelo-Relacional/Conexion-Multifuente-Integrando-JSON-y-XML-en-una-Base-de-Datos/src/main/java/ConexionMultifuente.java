// clases necesarias para manejar JSON
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
// clases necesarias para manejar XML
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// clase necesaria para manejar rutas de archivos
import java.io.File;
// clase necesaria para trabajar con bases de datos
import java.sql.*;
// otras clases de java para manejar listas (correos y teléfonos)
import java.util.ArrayList;
import java.util.List;

public class ConexionMultifuente {
    static final String url = "jdbc:postgresql://localhost:5432/usuarios_empresas";
    static final String user = "postgres";
    static final String password = "postgres";

    static File ficheroJSON = new File("C:\\Users\\gianc\\Documents\\GitHub\\DAM-2\\Acceso-A-Datos\\resources\\datos.json");
    static File ficheroXML = new File("C:\\Users\\gianc\\Documents\\GitHub\\DAM-2\\Acceso-A-Datos\\resources\\usuarios_Mercadona.xml");

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Conexión exitosa");

            int idEmpresaJson = insertarEmpresa(conn, "Pascual");
            int idEmpresaXml  = insertarEmpresa(conn, "Mercadona");

            parsearJSON(conn, ficheroJSON, idEmpresaJson);
            parsearXML(conn, ficheroXML, idEmpresaXml);

            mostrarResumen(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int insertarEmpresa(Connection conn, String nombre) throws SQLException {
        String sql = "INSERT INTO empresa(nombre) VALUES (?) RETURNING id_empresa";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    static void parsearJSON(Connection conn, File fichero, int idEmpresa) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(fichero);
        if (root.isArray()) {
            for (JsonNode nodo : root) {
                String nombre = nodo.get("nombre").asText();
                String apellido = nodo.get("apellido").asText();
                String dni = nodo.get("dni").asText();

                int idEmpleado = insertarEmpleado(conn, nombre, apellido, dni, idEmpresa);

                List<String> telefonos = mapper.convertValue(nodo.get("telefonos"), new TypeReference<List<String>>() {});
                for (String t : telefonos) insertarTelefono(conn, t, idEmpleado);

                List<String> correos = mapper.convertValue(nodo.get("correos"), new TypeReference<List<String>>() {});
                for (String c : correos) insertarCorreo(conn, c, idEmpleado);
            }
        }
    }

    static void parsearXML(Connection conn, File fichero, int idEmpresa) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fichero);

        NodeList nodos = doc.getElementsByTagName("Usuario");
        for (int i = 0; i < nodos.getLength(); i++) {
            Element e = (Element) nodos.item(i);
            String nombre = e.getElementsByTagName("Nombre").item(0).getTextContent().trim();
            String apellido = e.getElementsByTagName("Apellido").item(0).getTextContent().trim();
            String dni = e.getElementsByTagName("DNI").item(0).getTextContent().trim();

            int idEmpleado = insertarEmpleado(conn, nombre, apellido, dni, idEmpresa);

            NodeList correos = e.getElementsByTagName("Correo");
            for (int j = 0; j < correos.getLength(); j++) {
                insertarCorreo(conn, correos.item(j).getTextContent().trim(), idEmpleado);
            }

            NodeList telefonos = e.getElementsByTagName("Telefono");
            for (int j = 0; j < telefonos.getLength(); j++) {
                insertarTelefono(conn, telefonos.item(j).getTextContent().trim(), idEmpleado);
            }
        }
    }

    static int insertarEmpleado(Connection conn, String nombre, String apellido, String dni, int idEmpresa) throws SQLException {
        String sql = "INSERT INTO empleado(nombre, apellido, dni, id_empresa) VALUES (?,?,?,?) RETURNING id_empleado";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);
            ps.setInt(4, idEmpresa);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        }
    }

    static void insertarCorreo(Connection conn, String correo, int idEmpleado) throws SQLException {
        String sql = "INSERT INTO correo(correo, id_empleado) VALUES (?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, correo);
            ps.setInt(2, idEmpleado);
            ps.executeUpdate();
        }
    }

    static void insertarTelefono(Connection conn, String telefono, int idEmpleado) throws SQLException {
        String sql = "INSERT INTO telefono(telefono, id_empleado) VALUES (?,?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, telefono);
            ps.setInt(2, idEmpleado);
            ps.executeUpdate();
        }
    }

    static void mostrarResumen(Connection conn) throws SQLException {
        int empleados = 0, correos = 0, telefonos = 0;

        try (Statement st = conn.createStatement()) {
            ResultSet rs1 = st.executeQuery("SELECT COUNT(*) FROM empleado");
            if (rs1.next()) empleados = rs1.getInt(1);
            rs1.close();

            ResultSet rs2 = st.executeQuery("SELECT COUNT(*) FROM correo");
            if (rs2.next()) correos = rs2.getInt(1);
            rs2.close();

            ResultSet rs3 = st.executeQuery("SELECT COUNT(*) FROM telefono");
            if (rs3.next()) telefonos = rs3.getInt(1);
            rs3.close();
        }

        System.out.println("Resumen:");
        System.out.println("Empleados: " + empleados);
        System.out.println("Correos: " + correos);
        System.out.println("Teléfonos: " + telefonos);
    }

}