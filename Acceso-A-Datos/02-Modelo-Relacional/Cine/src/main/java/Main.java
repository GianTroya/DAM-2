import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. abrimos la conexión con un try-with-resources para cerrar la conexión automáticamente
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cine", "postgres", "postgres")) {

            try {
                // 2. insertamos un nuevo empleado
                insertarEmpleado(connection, new Empleado("Juan Pérez", "Seguridad", "Tiempo Completo", "juan.perez@cine.com", "555100024", LocalDate.of(2025, 10, 10), 75.00, true));
                // 3. eliminamos un empleado
                borrarEmpleado(connection, 1);
                // 4. hacemos una select
                buscarEmpleado(connection,24);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    // INSERTAR EMPLEADO
    public static void insertarEmpleado(Connection connection, Empleado empleado) {
        try {
            PreparedStatement insert = connection.prepareStatement("INSERT INTO empleados VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            insert.setString(1, empleado.getNombre());
            insert.setString(2, empleado.getPuesto());
            insert.setString(3, empleado.getTipoJornada());
            insert.setString(4, empleado.getEmail());
            insert.setString(5, empleado.getTelefono());
            insert.setDate(6, Date.valueOf(empleado.getFechaContratacion()));
            insert.setDouble(7, empleado.getSalarioHora());
            insert.setBoolean(8, empleado.isActivo());
            insert.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar empleado: " + e.getMessage());
        }
    }


    // BORRAR EMPLEADO
    public static void borrarEmpleado(Connection connection, int id) {
        try(PreparedStatement delete = connection.prepareStatement("DELETE FROM empleados WHERE id_empleado = ?")) {
            delete.setInt(1,1);
            delete.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al borrar empleado: " + e.getMessage());
        }
    }


    // BUSCAR EMPLEADO
    public static void buscarEmpleado(Connection connection, int id) {
        try (PreparedStatement select = connection.prepareStatement("SELECT * FROM empleados WHERE id_empleado = ?")) {
            select.setInt(1, id);
            //guardamos en memoria el resultado de los datos que pedimos
            try (ResultSet resultSet = select.executeQuery();) {
                // intentamos creamos un bucle para recorrer todos los registros, hasta que no haya más.
                while (resultSet.next()) {
                    Empleado empleado = new Empleado(
                            resultSet.getInt("id_empleado"),
                            resultSet.getString("nombre"),
                            resultSet.getString("puesto"),
                            resultSet.getString("tipo_jornada"),
                            resultSet.getString("email"),
                            resultSet.getString("telefono"),
                            resultSet.getDate("fecha_contratacion").toLocalDate(),
                            resultSet.getDouble("salario_hora"),
                            resultSet.getBoolean("activo")
                    );
                    System.out.println(empleado);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al seleccionar empleado: " + e.getMessage());
        }
    }
}