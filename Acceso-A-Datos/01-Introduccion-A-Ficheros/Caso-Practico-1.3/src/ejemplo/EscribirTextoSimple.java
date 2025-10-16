package ejemplo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirTextoSimple {

    public static void main(String[] args) {
        File directorioEjemplo = new File("unidad1_ejemplos");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdirs();
        }
        File ficheroSalida = new File(directorioEjemplo, "saludo_simple.txt");
        System.out.println("Escribiendo en: " + ficheroSalida.getAbsolutePath());

        // Usamos try-with-resources para BufferedWriter, que a su vez gestionará FileWriter
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {
            bw.write("¡Hola, mundo desde Acceso a Datos!"); // Escribe una cadena
            bw.newLine(); // Escribe un separador de línea dependiente del sistema
            bw.write("Esta es la segunda línea del fichero de texto.");
            bw.newLine();
            bw.write("Utilizando BufferedWriter para una escritura eficiente.");

            System.out.println("Texto escrito correctamente en " + ficheroSalida.getName());

        } catch (IOException e) {
            System.err.println("Error al escribir texto: " + e.getMessage());
        }
    }
}