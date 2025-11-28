package multiHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCPEcoMultihilo {
    public static void main(String[] args) {
        int puerto = 7000;
        int contadorClientes = 0;

        try (ServerSocket socketServidor = new ServerSocket(puerto)) {
            System.out.println("Servidor de Eco Multihilo iniciado en el puerto " + puerto + "...");
            System.out.println("Esperando conexiones de clientes...");

            while (true) { // Bucle infinito para aceptar clientes continuamente
                Socket socketCliente = socketServidor.accept(); // Bloqueante, espera una conexión
                contadorClientes++;
                System.out.println("Cliente [" + contadorClientes + "] conectado desde: " +
                                   socketCliente.getInetAddress().getHostAddress() +
                                   ":" + socketCliente.getPort());

                // Crear un nuevo hilo para manejar la comunicación con este cliente
                HiloClienteServidor hiloCliente = new HiloClienteServidor(socketCliente, contadorClientes);
                hiloCliente.start(); // Inicia la ejecución del hilo (llama a su método run())
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor principal: " + e.getMessage());
            e.printStackTrace();
        }
    }
}