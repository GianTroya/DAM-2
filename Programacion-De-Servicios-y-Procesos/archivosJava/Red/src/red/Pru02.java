package red;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Pru02 {

	public static void main(String[] args) {
		try {
		    InetAddress googleIP = InetAddress.getByName("www.google.com");
		    System.out.println("IP de Google: " + googleIP.getHostAddress());
		} catch (UnknownHostException e) {
		    System.err.println("No se pudo resolver el host: " + e.getMessage());
		}

	}

}
