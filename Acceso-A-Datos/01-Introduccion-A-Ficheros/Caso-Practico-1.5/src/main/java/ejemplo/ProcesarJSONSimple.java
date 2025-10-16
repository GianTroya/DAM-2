package ejemplo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProcesarJSONSimple {

    public static void main(String[] args) {
        File directorioEjemplo = new File("unidad1_ejemplos");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdirs();
        }

        File archivoJSON = new File(directorioEjemplo, "usuarioJSON.json");

        // 1. Crear el fichero JSON si no existe
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

        // 2. Leer y parsear el fichero JSON usando Jackson
        ObjectMapper mapper = new ObjectMapper();

        try {
            System.out.println("Parseando: " + archivoJSON.getName());
            JsonNode rootNode = mapper.readTree(archivoJSON);

            // Acceder a los valores por clave
            String nombre = rootNode.get("nombre").asText();
            int edad = rootNode.get("edad").asInt();
            boolean activo = rootNode.get("activo").asBoolean();

            System.out.println("Datos del usuario:");
            System.out.println(" Nombre: " + nombre);
            System.out.println(" Edad: " + edad);
            System.out.println(" Activo: " + activo);

            // Acceder a un array
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
