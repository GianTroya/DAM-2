package red;

import java.io.*;
import java.net.*;
// hay que ejecutar el cliente y el servidor
public class ClienteTCPSimple {
    public static void main(String[] args) {
        String hostServidor = "localhost"; // O la IP del servidor
        int puertoServidor = 5000;
        System.out.println("Cliente TCP Iniciado. Intentando conectar a " + hostServidor + ":" + puertoServidor + "...");

        try (Socket socket = new Socket(hostServidor, puertoServidor);
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Conectado al servidor.");

            String mensajeAEnviar = "Hola Servidor, soy un cliente TCP!";
            salida.println(mensajeAEnviar); // Enviar mensaje al servidor
            System.out.println("Mensaje enviado al servidor: " + mensajeAEnviar);

            String respuestaServidor = entrada.readLine(); // Leer respuesta del servidor
            System.out.println("Servidor responde: " + respuestaServidor);

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + hostServidor + " - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S al conectar o comunicarse con el servidor: " + e.getMessage());
        }
        System.out.println("Cliente TCP Terminado.");
    }
}