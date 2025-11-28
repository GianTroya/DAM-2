import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // 1. abrimos la conexión con un try-with-resources para cerrar la conexión automáticamente
        try (Connection connection = Conexion.obtenerConnection()) {

                // 2. insertamos un nuevo empleado
                GestionEmpleado.insertarEmpleado(connection, new Empleado("Juan Pérez", "Seguridad", "Tiempo Completo", "juan.perez@cine.com", "555100024", LocalDate.of(2025, 10, 10), 75.00, true));
                // 3. eliminamos un empleado
                GestionEmpleado.borrarEmpleado(connection, 1);
                // 4. hacemos una select
                GestionEmpleado.buscarEmpleado(connection,24);

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}