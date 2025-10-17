package ejemplo;

//Estas clases vienen de la biblioteca Jackson, que sirve para convertir entre JSON y objetos Java.
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//Estas son clases estándar de Java para trabajar con archivos.
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesarJSONSimple {

    public static void main(String[] args) {
        //Crea una carpeta llamada unidad1_ejemplos si no existe.
        File directorioEjemplo = new File("unidad1_ejemplos");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdirs();
        }

        //Define el archivo usuarioJSON.json dentro de esa carpeta.
        File archivoJSON = new File(directorioEjemplo, "usuarioJSON.json");

        // 1. Si el archivo no existe, lo crea con contenido JSON que representa a una persona llamada Elena.
        if (!archivoJSON.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoJSON))) {
                writer.write("{\n");
                writer.write("  \"nombre\": \"Elena\",\n");
                writer.write("  \"email\": \"elena@example.com\",\n");
                writer.write("  \"edad\": 27,\n");
                writer.write("  \"activo\": false,\n");
                writer.write("  \"hobbies\": [\"leer\", \"senderismo\"]\n");
                writer.write("}\n");
                System.out.println("¡Fichero JSON de ejemplo creado! " + archivoJSON.getName());
            } catch (IOException e) {
                System.err.println("Error al crear el fichero JSON de ejemplo.");
                System.err.println("=> Salimos si no se puede crear");
            }
        }

        // 2. Leer y parsear el fichero JSON usando Jackson. ObjectMapper es la clase de Jackson que convierte entre JSON y objetos Java.
        ObjectMapper mapper = new ObjectMapper();

        //3. Extraer datos del JSON
        try {
            System.out.println("Parseando: " + archivoJSON.getName());
            JsonNode rootNode = mapper.readTree(archivoJSON);

            // Acceder a los valores por clave
            String nombre = rootNode.get("nombre").asText();
            int edad = rootNode.get("edad").asInt();
            boolean activo = rootNode.get("activo").asBoolean();

            // Imprime esos valores por consola
            System.out.println("Datos del usuario:");
            System.out.println(" Nombre: " + nombre);
            System.out.println(" Edad: " + edad);
            System.out.println(" Activo: " + activo);

            // Acceder a un array de hobbies y muestra cada hobbie
            JsonNode hobbiesNode = rootNode.get("hobbies");
            if (hobbiesNode != null && hobbiesNode.isArray()) {
                System.out.print(" Hobbies: ");
                for (JsonNode hobby : hobbiesNode) {
                    System.out.print(hobby.asText() + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error al leer o parsear el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
