package ejemplo;

import java.util.Scanner;
import java.util.regex.Pattern; // Para usar expresiones regulares

public class ValidacionNombreUsuario {

    // Constantes para las reglas de validación
    private static final int MIN_LONGITUD = 5;
    private static final int MAX_LONGITUD = 20;
    // Expresión regular: ^ indica inicio de cadena, [a-zA-Z0-9] permite letras y números,
    // + indica una o más ocurrencias, $ indica fin de cadena.
    private static final Pattern PATRON_ALFANUMERICO = Pattern.compile("^[a-zA-Z0-9]+$");

    public static boolean esNombreUsuarioValido(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return false;
        }

        String trimmedNombreUsuario = nombreUsuario.trim(); // Quitar espacios al inicio/final para la longitud

        if (trimmedNombreUsuario.length() < MIN_LONGITUD || trimmedNombreUsuario.length() > MAX_LONGITUD) {
            System.out.println("Error: El nombre de usuario debe tener entre " + MIN_LONGITUD +
                    " y " + MAX_LONGITUD + " caracteres.");
            return false;
        }

        if (!PATRON_ALFANUMERICO.matcher(trimmedNombreUsuario).matches()) {
            System.out.println("Error: El nombre de usuario solo puede contener letras y números.");
            return false;
        }

        return true; // Si pasa todas las validaciones
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Registro de Nuevo Usuario ---");
        System.out.print("Introduce un nombre de usuario (5-20 caracteres, solo letras y números): ");
        String inputUsuario = scanner.nextLine();

        if (esNombreUsuarioValido(inputUsuario)) {
            System.out.println("Nombre de usuario '" + inputUsuario.trim() + "' es válido. ¡Procesando registro! (simulado)");
            // Aquí iría la lógica para guardar el nombre de usuario, hashearlo si fuera contraseña, etc.
        } else {
            System.out.println("El nombre de usuario introducido no es válido. Por favor, inténtalo de nuevo.");
        }

        scanner.close();
    }
}

// 6. Descifrar el mensaje
// Primero, decodificamos de Base64 si es necesario (si el mensaje cifrado viene como String Base64)
// byte[] bytesParaDescifrar = Base64.getDecoder().decode(mensajeCifradoBase64);
// En este caso, ya tenemos los bytes: mensajeCifradoBytes
/*byte[] mensajeDescifradoBytes = descifrador.doFinal(mensajeCifradoBytes);
String mensajeDescifrado = new String(mensajeDescifradoBytes, "UTF-8");
            System.out.println("Mensaje Descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
        System.err.println("Error durante la operación criptográfica: " + e.getMessage());
        e.printStackTrace();
        }
                }
                }*/