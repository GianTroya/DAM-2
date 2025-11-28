import java.sql.*;

public class Conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/cine";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    // obtenemos la conexión
    public static Connection obtenerConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
