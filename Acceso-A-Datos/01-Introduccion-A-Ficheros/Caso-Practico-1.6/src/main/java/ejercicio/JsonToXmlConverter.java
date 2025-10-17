package ejercicio;

import org.json.JSONObject;
import org.json.XML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonToXmlConverter {

    public static void main(String[] args) {
        String inputPath = "src/main/resources/data.json";  // Ruta del archivo JSON
        String outputPath = "data.xml";  // Ruta del archivo XML

        try {
            // Leer el contenido del archivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(inputPath)));

            // Convertir JSON a XML
            JSONObject jsonObject = new JSONObject(jsonContent);
            String xmlContent = XML.toString(jsonObject);

            // Guardar el XML en un archivo
            Files.write(Paths.get(outputPath), xmlContent.getBytes());

            System.out.println("Conversión completada. Archivo XML generado en: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error al leer o escribir archivos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error durante la conversión: " + e.getMessage());
        }
    }
}
