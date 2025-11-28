package factory_method;

public class FactoriaFacturas {
	public static Factura getFactura(String tipo) {
        if (tipo.equals("iva")) {
            return new FacturaIva();
        } else {
            return new FacturaIvaReducido();
        }
    }
	// Si nos fijamos la clase lo único que hace es instanciar un objeto u otro dependiendo 
	// del tipo que le solicitemos.Eso en un principio parece poco práctico. Pero vamos a ver 
	// como queda el programa main:
}
