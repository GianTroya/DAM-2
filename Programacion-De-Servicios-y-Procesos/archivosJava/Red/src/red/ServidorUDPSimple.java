package red;

import java.net.*;
import java.io.IOException;

public class ServidorUDPSimple {
    public static void main(String[] args) {
        int puerto = 6000;
        byte[] bufferRecepcion = new byte[1024]; // Buffer para recibir datos
        System.out.println("Servidor UDP Iniciado. Escuchando en el puerto " + puerto + "...");

        try (DatagramSocket socketUDP = new DatagramSocket(puerto)) {
            while (true) { // Bucle para atender múltiples clientes (secuencialmente aquí)
                DatagramPacket paqueteRecibido = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                socketUDP.receive(paqueteRecibido); // Espera (bloqueante) a recibir un paquete

                String mensajeCliente = new String(paqueteRecibido.getData(), 0, paqueteRecibido.getLength(), "UTF-8");
                InetAddress ipCliente = paqueteRecibido.getAddress();
                int puertoCliente = paqueteRecibido.getPort();
                System.out.println("Recibido de " + ipCliente.getHostAddress() + ":" + puertoCliente + " - Mensaje: " + mensajeCliente);

                String respuesta = "Servidor UDP dice: Mensaje '" + mensajeCliente + "' recibido.";
                byte[] bufferRespuesta = respuesta.getBytes("UTF-8");

                DatagramPacket paqueteRespuesta = new DatagramPacket(bufferRespuesta, bufferRespuesta.length, ipCliente, puertoCliente);
                socketUDP.send(paqueteRespuesta); // Enviar respuesta al cliente
                System.out.println("Respuesta enviada a " + ipCliente.getHostAddress() + ":" + puertoCliente);
                
                // Limpiar buffer para la siguiente recepción (opcional pero buena práctica si se reutiliza)
                // bufferRecepcion = new byte[1024];
            }
        } catch (SocketException e) {
            System.err.println("Error de Socket UDP: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de E/S UDP: " + e.getMessage());
        }
        System.out.println("Servidor UDP Terminado."); // No se alcanzará con while(true)
    }
}
