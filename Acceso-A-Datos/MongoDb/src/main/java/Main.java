import com.google.gson.*;
import org.bson.Document;
import com.mongodb.client.*;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        try {
            // 1. Crear objeto Gson
            Gson gson = new Gson();

            // 2. Leer el archivo datos.json y convertirlo en JsonArray
            JsonArray jsonArray = gson.fromJson(
                    new FileReader("C:\\Users\\gianc\\Documents\\GitHub\\DAM-2\\Acceso-A-Datos\\MongoDb\\src\\main\\resources\\alumnos.json"),
                    JsonArray.class
            );

            // 3. Conectar con MongoDB
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

            // 4. Seleccionar la base de datos "Clase"
            MongoDatabase db = mongoClient.getDatabase("Clase");

            // 5. Seleccionar la colección "alumnos"
            MongoCollection<Document> coleccion = db.getCollection("alumnos");

            // 6. Recorrer el array e insertar cada objeto
            for (JsonElement elemento : jsonArray) {

                JsonObject jsonObj = elemento.getAsJsonObject();

                // Convertir cada objeto JSON a Document
                Document doc = Document.parse(jsonObj.toString());

                // Insertar en MongoDB
                coleccion.insertOne(doc);

                System.out.println("Insertado: " + jsonObj.get("nombre").getAsString());
            }

            System.out.println("Todos los documentos fueron insertados correctamente.");

            // 7. Cerrar conexión
            mongoClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
