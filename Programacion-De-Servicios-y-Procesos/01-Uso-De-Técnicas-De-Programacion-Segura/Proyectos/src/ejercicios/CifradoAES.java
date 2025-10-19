package ejercicios;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CifradoAES {

    public static void main(String[] args) {
        try {
            // 1. Generar una clave AES
            SecretKey clave = KeyGenerator.getInstance("AES").generateKey();

            // 2. Crear un objeto Cipher para AES
            Cipher cipher = Cipher.getInstance("AES");

            // 3. Inicializar en modo ENCRYPT_MODE para cifrar
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            String mensaje = "Hola mundo secreto";
            byte[] mensajeCifrado = cipher.doFinal(mensaje.getBytes());

            // 4. Inicializar en modo DECRYPT_MODE para descifrar
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] mensajeDescifrado = cipher.doFinal(mensajeCifrado);
            String resultado = new String(mensajeDescifrado);

            // Mostrar resultados
            System.out.println("Mensaje original: " + mensaje);
            System.out.println("Mensaje descifrado: " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}