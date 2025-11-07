//Estas clases vienen de la biblioteca Jackson, que sirve para convertir entre JSON y objetos Java.
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//Estas son clases estándar de Java para trabajar con archivos.
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
// otras clases de java
import java.io.IOException;
import java.util.ArrayList;
// clases para bases de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class ParsearJSONYXML {
    // atributos
    public static final String url = "jdbc:postgresql://localhost:5432/usuarios_empresas";
    public static final String user = "postgres";
    public static final String password = "postgres";

    public static File carpetaRecursos = new File("C:\\Users\\gianc\\Documents\\GitHub\\DAM-2\\Acceso-A-Datos\\02-Modelo-Relacional\\Recursos");
    public static File ficheroJSON = new File(carpetaRecursos, "usuarios_Pascual.json");
    public static File ficheroXML = new File(carpetaRecursos, "empleados.xml");



    // main
    public static void main(String[] args) {
//        intentamos conectarnos a la base de datos
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a usuarios_empresas: " + e.getMessage());
            e.printStackTrace();
        }
//        intentamos parsear el fichero JSON usando Jackson e insertar una query.
        ObjectMapper mapper = new ObjectMapper();
        try{
            System.out.println("Parseando: " + ficheroJSON.getName());
            JsonNode rootNode = mapper.readTree(ficheroJSON);
            if (rootNode.isArray()) {
                for (JsonNode usuarioNode : rootNode) {
                    //Acceder a los valores por nombre
                    String nombre = usuarioNode.get("nombre").asText();
                    String apellido = usuarioNode.get("apellido").asText();
                    String dni = usuarioNode.get("dni").asText();
                    // Obtener el array de teléfonos
                    JsonNode telefonosNode = usuarioNode.get("telefonos");
                    // Crear un arrayList de Strings con los valores
                    List<String> telefonos = mapper.convertValue(telefonosNode, new TypeReference<List<String>>() {});
                    // Obtener el array de correos
                    JsonNode correosNode = usuarioNode.get("correos");
                    // Crear un array de Strings con los valores
                    List<String> correos = mapper.convertValue(correosNode, new TypeReference<List<String>>() {});

                    String sentencia = "INSERT INTO empleados VALUES ('" + nombre  + "', '" + apellido + "', '" + dni + "', '" + ("{" + String.join(", ", telefonos) + "}") + "', '" + ("{" + String.join(", ", correos) + "}');");
                    System.out.println(sentencia);

                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
//        intentamos parsear el fichero JSON usando Jackson e insertar una query.
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento =builder.parse(ficheroXML);

            // Obtenemos el elemento raiz
            Element elementoRaiz = documento.getDocumentElement();
            System.out.println("Elemento raíz: " + elementoRaiz.getNodeName());
            // recorremos los hijos
            NodeList nodosUsuario = elementoRaiz.getElementsByTagName("Usuario");
            for (int i = 0; i < nodosUsuario.getLength(); i++) {
                Node nodo = nodosUsuario.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
                    String apellido = elemento.getElementsByTagName("Apellido").item(0).getTextContent().trim();
                    String dni = elemento.getElementsByTagName("DNI").item(0).getTextContent().trim();
                    NodeList correosNodeList = elemento.getElementsByTagName("Correo");
                    List<String> correos = new ArrayList<>();
                    for (int j = 0; j < correosNodeList.getLength(); j++){
                        Node node = correosNodeList.item(j);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            correos.add(node.getTextContent().trim());
                        }
                    }
                    NodeList telefonosNodeList = elemento.getElementsByTagName("Telefono");
                    List<String> telefonos = new ArrayList<>();
                    for (int j = 0; j < telefonosNodeList.getLength(); j++){
                        Node node = telefonosNodeList.item(j);
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            telefonos.add(node.getTextContent().trim());
                        }
                    }
                    String sentencia = "INSERT INTO empleados VALUES ('" + nombre  + "', '" + apellido + "', '" + dni + "', '" + ("{" + String.join(", ", telefonos) + "}") + "', '" + ("{" + String.join(", ", correos) + "}');");
                    System.out.println(sentencia);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}