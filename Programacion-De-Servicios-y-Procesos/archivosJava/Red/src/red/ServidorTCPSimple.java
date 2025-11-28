package red;

import java.io.*;
import java.net.*;

public class ServidorTCPSimple {
    public static void main(String[] args) {
        int puerto = 5000; // Puerto en el que escuchará el servidor
        System.out.println("Servidor TCP Iniciado. Escuchando en el puerto " + puerto + "...");

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            // Esperar una conexión de un cliente (bloqueante)
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress().getHostAddress() + ":" + clienteSocket.getPort());

            // Preparar flujos para leer del cliente y escribir al cliente
            // Usamos try-with-resources para asegurar el cierre de los flujos y el socket del cliente
            try (BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                 PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true)) { // true para autoFlush

                String mensajeCliente = entrada.readLine(); // Leer mensaje del cliente
                System.out.println("Cliente dice: " + mensajeCliente);

                salida.println("Servidor dice: Hola Cliente, mensaje recibido: '" + mensajeCliente + "'"); // Enviar respuesta

            } catch (IOException e) {
                System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
            }
            System.out.println("Conexión con el cliente cerrada.");

        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor TCP: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Servidor TCP Terminado.");
    }
}
