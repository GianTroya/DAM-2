import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec; // Para el Vector de Inicialización (IV)
import java.security.SecureRandom;      // Para generar un IV seguro
import java.util.Base64;                // Para mostrar bytes de forma legible

public class CifradoAESEjemplo {

    public static void main(String[] args) {
        try {
            String mensajeOriginal = "Este es un mensaje súper secreto que nadie debe leer.";
            System.out.println("Mensaje Original: " + mensajeOriginal);

            // 1. Generar una clave secreta para AES
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256); // Usar claves de 128, 192 o 256 bits para AES
            SecretKey claveSecreta = keyGenerator.generateKey();
            System.out.println("Clave Secreta Generada (formato): " + claveSecreta.getFormat());

            // 2. Generar un Vector de Inicialización (IV) - ¡MUY IMPORTANTE para modos como CBC!
            // Un IV debe ser aleatorio y único para cada operación de cifrado con la misma clave.
            // No necesita ser secreto, pero sí impredecible.
            byte[] ivBytes = new byte[16]; // Para AES, el IV suele ser de 16 bytes (128 bits)
            SecureRandom random = new SecureRandom();
            random.nextBytes(ivBytes);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);
            System.out.println("IV Generado (Base64): " + Base64.getEncoder().encodeToString(ivBytes));

            // 3. Inicializar el objeto Cipher para CIFRADO
            // Usaremos AES con modo CBC y padding PKCS5Padding, que requiere un IV.
            Cipher cifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cifrador.init(Cipher.ENCRYPT_MODE, claveSecreta, ivParameterSpec);

            // 4. Cifrar el mensaje
            byte[] mensajeCifradoBytes = cifrador.doFinal(mensajeOriginal.getBytes("UTF-8"));
            String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(mensajeCifradoBytes);
            System.out.println("Mensaje Cifrado (Base64): " + mensajeCifradoBase64);

            // --- Proceso de Descifrado ---

            // 5. Inicializar el objeto Cipher para DESCIFRADO
            // ¡IMPORTANTE! Se debe usar la MISMA clave secreta y el MISMO IV que se usó para cifrar.
            Cipher descifrador = Cipher.getInstance("AES/CBC/PKCS5Padding");
            descifrador.init(Cipher.DECRYPT_MODE, claveSecreta, ivParameterSpec);

            // 6. Descifrar el mensaje
            // Primero, decodificamos de Base64 si es necesario (si el mensaje cifrado viene como String Base64)
            // byte[] bytesParaDescifrar = Base64.getDecoder().decode(mensajeCifradoBase64);
            // En este caso, ya tenemos los bytes: mensajeCifradoBytes
            byte[] mensajeDescifradoBytes = descifrador.doFinal(mensajeCifradoBytes);
            String mensajeDescifrado = new String(mensajeDescifradoBytes, "UTF-8");
            System.out.println("Mensaje Descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            System.err.println("Error durante la operación criptográfica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}