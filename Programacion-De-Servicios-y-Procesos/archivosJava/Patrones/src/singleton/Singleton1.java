package singleton;

public final class Singleton1 {
	// El campo debe declararse como volátil para que el bloqueo de doble verificación funcione
    // correctamente. modificar un atributo con la palabra clave volatile significa que se está 
	//indicando a la máquina virtual de Java (JVM) y al compilador que el valor de esta variable 
	//será compartido entre diferentes hilos y que su valor puede cambiar en cualquier momento
	// lectura o escritura de esa variable se realice directamente en la memoria principal, evitando 
	// la caché del CPU de cada hilo
    private static volatile Singleton1 instance;
    public String value;
    private Singleton1(String value) {
        this.value = value;
    }
    public static Singleton1 getInstance(String value) {
    	   // El enfoque adoptado aquí se denomina bloqueo de doble verificación (DCL). Su
        // finalidad es evitar la condición de carrera entre varios subprocesos que pueden
        // intentar obtener una instancia única al mismo tiempo, creando así
        // instancias separadas.
        // Puede parecer que tener la variable `result` aquí es completamente
        // inútil. Sin embargo, hay una advertencia muy importante al
        // implementar el bloqueo de doble verificación en Java, que se resuelve
        // introduciendo esta variable local.
        Singleton1 result = instance;
        if (result != null) {
            return result;
        }
        synchronized(Singleton1.class) {
            if (instance == null) {
                instance = new Singleton1(value);
            }
            return instance;
        }
    }
}
