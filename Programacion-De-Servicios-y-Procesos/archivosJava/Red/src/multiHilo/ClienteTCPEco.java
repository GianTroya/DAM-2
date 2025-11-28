package multiHilo;

import java.io.*;
import java.net.*;
import java.util.Scanner;
// hay que ejecutarlo varias veces de modo que se crean los hilos
public class ClienteTCPEco {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 7000;

        try (
            Socket socket = new Socket(host, puerto);
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scannerConsola = new Scanner(System.in)
        ) {
            System.out.println("Conectado al Servidor de Eco en " + host + ":" + puerto);
            System.out.println("Escribe mensajes para enviar al servidor. Escribe 'adios' para salir.");

            String lineaUsuario;
            while (true) {
                System.out.print("Cliente > ");
                lineaUsuario = scannerConsola.nextLine();
                salida.println(lineaUsuario); // Enviar al servidor

                if ("adios".equalsIgnoreCase(lineaUsuario.trim())) {
                    break;
                }

                String respuestaServidor = entrada.readLine(); // Leer eco del servidor
                System.out.println("Servidor < " + respuestaServidor);
            }
            System.out.println("Desconectando del servidor...");

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + host);
        } catch (IOException e) {
            System.err.println("Error de E/S: " + e.getMessage());
        }
    }
}