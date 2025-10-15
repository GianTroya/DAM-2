import java.io.File;
import java.io.IOException;

public class GestionSimpleFichero {
    public static void main(String[] args) {
        // Usamos una subcarpeta para mantener organizados los ejemplos
        File rutaDirectorio = new File("unidad1_ejemplos");
        if (!rutaDirectorio.exists()) {
            rutaDirectorio.mkdirs(); // Crear directorio si no existe
        }

        // Referencia al fichero dentro de la subcarpeta
        File rutaFichero = new File(rutaDirectorio, "mi_fichero_prueba.txt");
        System.out.println("Operando con: " + rutaFichero.getAbsolutePath());

        try {
            // Crear el fichero si no existe
            if (rutaFichero.createNewFile()) {
                System.out.println("Fichero creado: " + rutaFichero.getName());
            } else {
                System.out.println("El fichero ya existe: " + rutaFichero.getName());
            }

            // Mostrar propiedades
            if (rutaFichero.exists()) {
                System.out.println("Propiedades de: '" + rutaFichero.getName() + "':");
                System.out.println("  - Es un fichero: " + rutaFichero.isFile());
                System.out.println("  - Es un directorio: " + rutaFichero.isDirectory());
                System.out.println("  - Se puede leer: " + rutaFichero.canRead());
                System.out.println("  - Se puede escribir: " + rutaFichero.canWrite());
                System.out.println("  - Tamaño (bytes): " + rutaFichero.length());
            }
        } catch (IOException e) {
            System.err.println("Error de E/S al operar con el fichero: " + e.getMessage());
            System.err.println("Verifica los permisos en: " + rutaDirectorio.getAbsolutePath());
        }

        // Opcional: limpieza (descomentar si quieres eliminar el fichero y directorio)
        if (rutaFichero.exists()) {
            if (rutaFichero.delete()) {
                System.out.println("Fichero de prueba eliminado: " + rutaFichero.getName());
            } else  {
                System.err.println("Error al eliminar el fichero de prueba.");
            }
            if (rutaDirectorio.delete()) {
                System.out.println("Directorio de prueba eliminado: " + rutaDirectorio.getName());
            }
        }

    }
}