package ejemplo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirBytesSimple {

    public static void main(String[] args) {
        File directorioEjemplo = new File("unidad1_ejemplos");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdirs();
        }

        File ficheroSalida = new File(directorioEjemplo, "datos_simples.bin");
        System.out.println("Escribiendo en: " + ficheroSalida.getAbsolutePath());

        // try-with-resources asegura que el flujo ‘fos’ se cierre automáticamente
        // al finalizar el bloque try, incluso si ocurren excepciones.
        try (FileOutputStream fos = new FileOutputStream(ficheroSalida)) {
            // Escribimos unos pocos bytes
            fos.write(72);  // 'H' en ASCII
            fos.write(101); // 'e' en ASCII
            fos.write(108); // 'l' en ASCII
            fos.write(108); // 'l' en ASCII
            fos.write(111); // 'o' en ASCII

            byte[] masDatos = {32, 87, 111, 114, 108, 100, 33}; // " World!" en ASCII
            fos.write(masDatos); // Escribe un array de bytes

            System.out.println("Bytes escritos correctamente en " + ficheroSalida.getName());

        } catch (IOException e) {
            System.err.println("Error al escribir bytes: " + e.getMessage());
        }
    }
}