package ejercicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RemplazarComasPorPuntoYComa {

    public static void main(String[] args) {
        // Creamos el texto del fichero
        String textoLargo =
                "Este es un ejemplo de texto, que contiene varias comas, "
                + "para demostrar cómo reemplazarlas, por punto y coma, "
                + "utilizando Java, de forma sencilla.";

        // Creamos la ruta del fichero si no existe
        File directorio = new File("unidad1_ejemplos");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }

        // Creamos la ruta del archivo original y el modificado en el mismo directorio
        File archivoOriginal = new File(directorio, "texto_original.txt");
        File archivoModificado = new File(directorio, "texto_modificado.txt");

        // 1. Guardar el texto original en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoOriginal))) {
            writer.write(textoLargo);
            System.out.println("Texto original guardado en: " + archivoOriginal.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar el texto original: " + e.getMessage());
            return;
        }

        // 2. Leer, reemplazar comas por punto y coma y guardar en nuevo archivo
        try (
                BufferedReader reader = new BufferedReader(new FileReader(archivoOriginal));
                BufferedWriter writer = new BufferedWriter(new FileWriter(archivoModificado))
        ) {
            // Creamos una variable auxiliar para guardar una línea de texto
            String linea;
            // Reemplazamos los separadores y los escribimos en el nuevo fichero modificado hasta que no haya ningún texto en la línea
            while ((linea = reader.readLine()) != null) {
                String lineaModificada = linea.replace(",", ";");
                writer.write(lineaModificada);
                writer.newLine(); // Preserva saltos de línea si el texto fuera multilineal
            }
            System.out.println("Texto modificado guardado en: " + archivoModificado.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}