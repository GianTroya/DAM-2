package red;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Pru01 {
	public static void main(String[] args) {
		try {
		    InetAddress miIP = InetAddress.getLocalHost();
		    System.out.println("Mi IP local: " + miIP.getHostAddress()); // Muestra la IP
		    System.out.println("Mi nombre de host local: " + miIP.getHostName()); // Muestra el nombre
		} catch (UnknownHostException e) {
		    System.err.println("No se pudo obtener la IP local: " + e.getMessage());
		}	
	}

}
