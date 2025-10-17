package ejemplo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ManejoFicherosSimple {

    public static void main(String[] args) {
        File directorioEjemplo = new File("unidad1_ejemplos");
        // Si el directorioEjemplo no existe pasa este ejemplo, para evitar el error si no existe

        File ficheroProcesa = new File(directorioEjemplo, "fichero1.txt");
        System.out.println("Intentando leer: " + ficheroProcesa.getAbsolutePath());

        // Usamos try-with-resources para que BufferedReader se cierre automáticamente
        try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(ficheroProcesa))) {
            // Si el fichero falla al abrir (porque no existe, por ejemplo), se lanza FileNotFoundException
            // El recurso no llegaría a abrirse y por lo que no habría que cerrarlo (try-with-resources)
            String linea = flujoEntrada.readLine();

            while (linea != null) {
                System.out.println("Linea encontrada. Leyendo contenido...");
                System.out.println(linea);
                linea = flujoEntrada.readLine();
            }

            // Si el fichero existe, el BufferedReader se cerrará automáticamente al salir del try
        } catch (FileNotFoundException ex) {
            // Se lanza en el catch específico para cuando el fichero no se encuentra
            System.err.println("Fichero no encontrado: " + ficheroProcesa.getAbsolutePath());
            System.err.println("Ruta incorrecta o el fichero no existe.");
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Por favor, asegúrate de que el fichero existe.");
        } catch (IOException ex) {
            // IOException se lanza si hay un error de E/S cuando se lee el fichero
            System.err.println("Error de E/S al leer el fichero: " + ficheroProcesa.getAbsolutePath());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Intenta la tarea de nuevo.");
        } finally {
            System.out.println("Bloque 'finally': Si se ha ejecutado este mensaje, haya o no existido el fichero, se ha intentado leer el fichero.");
        }

        System.out.println("Final del programa.");
    }
}