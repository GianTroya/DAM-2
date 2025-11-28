package profe;

//HiloContador.java
class HiloContador extends Thread {
 private volatile boolean ejecutando = true; // Bandera para controlar el bucle

 public HiloContador(String nombre) {
     super(nombre);
 }

 @Override
 public void run() {
     System.out.println("Hilo '" + getName() + "' iniciado.");
     int contador = 0;
     try {
         // Bucle principal del hilo
         // Comprobamos dos cosas: la bandera 'ejecutando' Y si el hilo ha sido interrumpido.
         // Thread.currentThread().isInterrupted() comprueba la bandera de interrupción.
         while (ejecutando && !Thread.currentThread().isInterrupted()) {
             contador++;
             System.out.println("Hilo '" + getName() + "' contando: " + contador);

             // Hacemos que el hilo "duerma" por 1 segundo.
             // sleep() es un método que responde a interrupciones lanzando InterruptedException.
             Thread.sleep(1000); // 1000 milisegundos = 1 segundo
         }
     } catch (InterruptedException e) {
         // Esto se ejecuta si el hilo es interrumpido MIENTRAS está en sleep() (o wait(), join()).
         // La bandera de interrupción se limpia cuando se lanza InterruptedException.
         // Es buena práctica restaurarla si el hilo va a terminar debido a esto,
         // o si otro código más arriba en la pila de llamadas necesita saberlo.
         // Thread.currentThread().interrupt(); // Opcional aquí, ya que saldremos del bucle.
         System.out.println("Hilo '" + getName() + "' fue INTERRUMPIDO (durante sleep o espera). Terminando.");
     } finally {
         // Este bloque se ejecuta siempre, ya sea que el bucle termine normalmente
         // o por una excepción (como InterruptedException).
         System.out.println("Hilo '" + getName() + "' finalizando su ejecución.");
     }
 }

 // Método opcional para detener el hilo de forma "suave" desde fuera,
 // si no queremos depender solo de interrupt().
 public void detener() {
     ejecutando = false;
     // Si el hilo podría estar en sleep() o wait(), también deberíamos interrumpirlo
     // para que salga de ese estado bloqueante y pueda verificar la bandera 'ejecutando'.
     interrupt();
 }
}
