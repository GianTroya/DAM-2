import java.io.*;

public class Arbol implements Serializable{
private static final long serialVersionUID = 1L;
private String nombreVulgar;
private String nombreCientifico;
private double alturaMedia;
Arbol (String nombre) {
this.nombreVulgar=nombre;
}
public void ponNombreCientifico (String nombre) {
this.nombreCientifico=nombre;
}
public void ponAlturaMedia (double altura) {
alturaMedia=altura;
}
public String muestraArbol () {
return nombreVulgar+ " "+ nombreCientifico + " " + alturaMedia;
}
}