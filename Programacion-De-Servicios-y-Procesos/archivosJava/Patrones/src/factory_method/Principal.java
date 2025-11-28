package factory_method;

public class Principal {
    public static void main(String[] args) {
        Factura f = FactoriaFacturas.getFactura("iva");
    //    Factura f = FactoriaFacturas.getFactura(""); la cifra dará diferente
        f.setId(1);
        f.setImporte(100);
        System.out.println(f.getImporteIva());
    }
    // Nos podemos dar cuenta que el programador ya solo tiene que tratar con el concepto de 
    // Factura para el la clase FacturaIva y FacturaReducido no existen.
}
