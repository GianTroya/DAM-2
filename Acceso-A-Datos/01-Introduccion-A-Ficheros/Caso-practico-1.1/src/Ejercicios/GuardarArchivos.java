package Ejercicios;

import java.io.File;
import java.io.IOException;

public class GuardarArchivos {
    public static void main(String[] args) {
        String baseNombreCarpeta = "Carpeta";
        File carpetaActual = new File(baseNombreCarpeta);

        // Buscar carpeta válida (si hay más de 5 archivos, crear nueva)
        int sufijoCarpeta = 0;
        while (carpetaActual.exists() && carpetaActual.listFiles().length >= 5) {
            sufijoCarpeta++;
            carpetaActual = new File(baseNombreCarpeta + sufijoCarpeta);
        }

        // Crear carpeta si no existe
        if (!carpetaActual.exists()) {
            carpetaActual.mkdirs();
        }

        // Buscar siguiente nombre de archivo disponible
        int contador = 1;
        File nuevoArchivo;
        do {
            nuevoArchivo = new File(carpetaActual, "archivo" + contador + ".txt");
            contador++;
        } while (nuevoArchivo.exists());

        try {
            if (nuevoArchivo.createNewFile()) {
                System.out.println("Archivo creado: " + nuevoArchivo.getAbsolutePath());
            } else {
                System.err.println("No se pudo crear el archivo.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
