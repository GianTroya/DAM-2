package ejemplo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ParsearXMLSimple {
    public static void main(String[] args) {
        File directorioEjemplo = new File("files");
        if (!directorioEjemplo.exists()) {
            directorioEjemplo.mkdir();
        }
        File archivoXML = new File(directorioEjemplo, "config.xml");

        // 1. Crear un fichero XML de ejemplo si no existe
        if (!archivoXML.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoXML))) {
                writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                writer.write("<config>\n");
                writer.write("  <nombre>Ejemplo</nombre>\n");
                writer.write("  <debug activado=\"true\" />\n");
                writer.write("  <configInfo id=\"1\" version=\"1.0\" />\n");
                writer.write("  <parametro id=\"p1\">valor1</parametro>\n");
                writer.write("  <parametro id=\"p2\">valor2</parametro>\n");
                writer.write("</config>\n");
                System.out.println("Fichero XML de ejemplo creado con DOM.");
            } catch (IOException e) {
                System.err.println("Error al crear el fichero XML de ejemplo.");
                return;
            }
        }

        // 2. Parsear el fichero XML con DOM
        try {
            System.out.println("Ruta del fichero XML: " + archivoXML.getAbsolutePath());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(archivoXML);

            // Obtenemos el elemento raíz
            Element elementoRaiz = documento.getDocumentElement();
            System.out.println("Elemento raíz: " + elementoRaiz.getNodeName());

            // Recorrer los hijos (ejemplo: los parámetros)
            NodeList nodosParametro = elementoRaiz.getElementsByTagName("parametro");
            for (int i = 0; i < nodosParametro.getLength(); i++) {
                Node nodo = nodosParametro.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String id = elemento.getAttribute("id");

                    String valor = elemento.getTextContent();
                    System.out.println("Parámetro encontrado -> ID: " + id + ", Valor: " + valor);
                }
            }

            NodeList nodosDebug = elementoRaiz.getElementsByTagName("debug");
            if (nodosDebug.getLength() > 0) {
                Element elementoDebug = (Element) nodosDebug.item(0);
                System.out.println("Debug activado: " + elementoDebug.getTextContent());
            }
        } catch (Exception e) {
            System.out.println("Error al parsear el XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
