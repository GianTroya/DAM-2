package ejercicio;

//Estas clases vienen de la biblioteca Jackson, que sirve para convertir entre JSON y objetos Java.
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//Estas son clases estándar de Java para trabajar con archivos.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesarDatosJSON {
    public static void main(String[] args) {
        //1. Buscar si se encuentra la carpeta con el archivo JSON
        File rutaCarpeta = new File("/resources");
        if (!rutaCarpeta.exists()) {
            rutaCarpeta.mkdirs();
        }
        //2. Comprobamos que existe el archivo JSON
        File rutaJSON = new File(rutaCarpeta, "datos.json");
        if (!rutaJSON.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaJSON))) {
                writer.write("[\n");
                writer.write("  {\n");
                writer.write("    \"employee\": \"John\",\n");
                writer.write("    \"salary\": 56000,\n");
                writer.write("    \"married\": true\n");
                writer.write("  },\n");
                writer.write("  {\n");
                writer.write("    \"employee\": \"Ana\",\n");
                writer.write("    \"salary\": 62000,\n");
                writer.write("    \"married\": false\n");
                writer.write("  }\n");
                writer.write("]\n");
                System.out.println("¡Fichero JSON de ejemplo creado! " + rutaJSON.getName());

            }catch (IOException e){
                System.err.println("Error al crear el fichero JSON de ejemplo.");
                System.err.println("=> Salimos si no se puede crear");
            }
        }
        // 3. Leer y parsear el fichero JSON usando Jackson. ObjectMapper es la clase de Jackson que convierte entre JSON y objetos Java.
        ObjectMapper mapper = new ObjectMapper();
        //4. Extraer datos del JSON
        try {
            System.out.println("Parseando: " + rutaJSON.getName());
            JsonNode rootNode = mapper.readTree(rutaJSON);
            if (rootNode.isArray()) {
                for (JsonNode empleadoNode : rootNode) {
                    String nombre = empleadoNode.get("employee").asText();
                    int salario = empleadoNode.get("salary").asInt();
                    boolean casado = empleadoNode.get("married").asBoolean();

                    System.out.println("Datos del empleado:");
                    System.out.println(" Nombre: " + nombre);
                    System.out.println(" Salario: " + salario);
                    System.out.println(" Casado: " + casado);
                    System.out.println("----------------------");
                }
            }

        }catch (IOException e) {
            System.err.println("Error al leer o parsear el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
