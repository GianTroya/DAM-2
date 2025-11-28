package red;
import java.net.*;
import java.io.*;

public class DescargarContenidoURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.ejemplo.com"); // Usa una URL que exista
            URLConnection conexion = url.openConnection();
            // Opcional: Configurar propiedades de la conexión si es necesario
            // conexion.setRequestProperty("User-Agent", "MiAplicacionJava/1.0");

            System.out.println("Conectando a: " + url.toString());
            System.out.println("Tipo de contenido: " + conexion.getContentType());
            System.out.println("Longitud del contenido: " + conexion.getContentLength() + " bytes");
            
            // Leer el contenido usando un InputStream
            // Usamos try-with-resources para asegurar que el stream se cierre
            try (InputStream input = conexion.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"))) { // Especificar UTF-8

                String linea;
                System.out.println("\n--- CONTENIDO ---");
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }
                System.out.println("--- FIN CONTENIDO ---");
            }

        } catch (MalformedURLException e) {
            System.err.println("Error: URL mal formada - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S al conectar o leer de la URL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
