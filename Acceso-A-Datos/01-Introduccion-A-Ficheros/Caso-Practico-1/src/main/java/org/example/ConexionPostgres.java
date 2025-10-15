package org.example;

import java.sql.Connection; //Para crear el objeto que nos permitirá conectarnos
import java.sql.DriverManager; //Para obtener la conexión a la base de datos
import java.sql.SQLException; //Para capturar errores relacionados con sql

public class ConexionPostgres {
    public static void main(String[] args) {
        //Generamos los atributos para la conexión
        String url = "jdbc:postgresql://localhost:5432/dam_prueba";
        String usuario = "postgres";
        String constraseña = "postgres";

        // Probamos con un try-with-resources el acceso a la conexión. Esto garantiza que la conexión se cierre automáticamente
        try (Connection conexion = DriverManager.getConnection(url,usuario,constraseña)) {
            System.out.println("Conexión exitosa a dam_prueba");
        } catch (SQLException e) {
            System.out.println("Error al conectar a dam_prueba: " + e.getMessage());
        }
    }
}