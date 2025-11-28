package red;

import java.net.MalformedURLException;
import java.net.URL;

public class pruURL {
public static void main(String[] args) {
	try {
	    URL miURL = new URL("https://www.ejemplo.com/documentos/informe.pdf?id=123#seccion2");
	} catch (MalformedURLException e) {
	    System.err.println("URL mal formada: " + e.getMessage());
	}
}
}
