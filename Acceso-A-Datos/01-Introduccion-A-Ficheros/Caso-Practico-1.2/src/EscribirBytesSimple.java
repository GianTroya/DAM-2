import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirBytesSimple {
    public static void main(String[] args) {
        File directorioEjemplo = new File("unidad1_ejemplos");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdir();
        }
        File ficheroSalida = new File(directorioEjemplo, "datos_simples.bin");
    }
}