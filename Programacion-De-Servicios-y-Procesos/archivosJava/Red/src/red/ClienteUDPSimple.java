package red;

import java.net.*;
import java.io.IOException;
import java.util.Scanner;

public class ClienteUDPSimple {
    public static void main(String[] args) {
        String hostServidor = "localhost";
        int puertoServidor = 6000;
        byte[] bufferRespuesta = new byte[1024];
        System.out.println("Cliente UDP Iniciado.");

        try (DatagramSocket socketCliente = new DatagramSocket()) { // Puerto efímero asignado por el SO
            InetAddress direccionServidor = InetAddress.getByName(hostServidor);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce mensaje para el servidor: ");
            String mensajeAEnviar = scanner.nextLine();
            byte[] bufferEnvio = mensajeAEnviar.getBytes("UTF-8");

            DatagramPacket paqueteAEnviar = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionServidor, puertoServidor);
            socketCliente.send(paqueteAEnviar);
            System.out.println("Mensaje enviado al servidor: " + mensajeAEnviar);

            // Esperar respuesta del servidor
            DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socketCliente.setSoTimeout(5000); // Establecer timeout de 5 segundos para receive()

            try {
                socketCliente.receive(paqueteRespuesta);
                String respuestaServidor = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength(), "UTF-8");
                System.out.println("Servidor responde: " + respuestaServidor);
            } catch (SocketTimeoutException e) {
                System.err.println("Timeout: No se recibió respuesta del servidor en 5 segundos.");
            }
            scanner.close();

        } catch (SocketException e) {
            System.err.println("Error de Socket UDP: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + hostServidor + " - " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S UDP: " + e.getMessage());
        }
        System.out.println("Cliente UDP Terminado.");
    }
}
