package multiHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class HiloClienteServidor extends Thread {
    private Socket socketCliente;
    private int idCliente;

    public HiloClienteServidor(Socket socketCliente, int idCliente) {
        this.socketCliente = socketCliente;
        this.idCliente = idCliente;
        setName("Cliente-" + idCliente + "-Thread"); // Asignar un nombre al hilo
    }

    @Override
    public void run() {
        System.out.println("Hilo para Cliente [" + idCliente + "] iniciado: " + getName());
        try (
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            PrintWriter salida = new PrintWriter(socketCliente.getOutputStream(), true) // true para autoFlush
        ) {
            String mensajeRecibido;
            // Bucle para leer mensajes del cliente hasta que envíe "adios" o cierre la conexión
            while ((mensajeRecibido = entrada.readLine()) != null) {
                System.out.println("Cliente [" + idCliente + "] dice: " + mensajeRecibido);

                if ("adios".equalsIgnoreCase(mensajeRecibido.trim())) {
                    salida.println("Servidor dice: Adiós, Cliente [" + idCliente + "]!");
                    break; // Salir del bucle while si el cliente dice "adios"
                }
                // Hacer eco del mensaje recibido, precedido por "Servidor Eco: "
                salida.println("Servidor Eco: " + mensajeRecibido);
            }
        } catch (IOException e) {
            System.err.println("Error de comunicación con Cliente [" + idCliente + "] (" + getName() + "): " + e.getMessage());
        } finally {
            try {
                if (socketCliente != null && !socketCliente.isClosed()) {
                    socketCliente.close(); // Asegurar que el socket del cliente se cierre
                }
            } catch (IOException ex) {
                System.err.println("Error al cerrar socket para Cliente [" + idCliente + "]: " + ex.getMessage());
            }
            System.out.println("Hilo para Cliente [" + idCliente + "] (" + getName() + ") terminado. Conexión cerrada.");
        }
    }
}