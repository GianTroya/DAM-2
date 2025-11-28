package profe;

//AppInterrupcion.java
public class AppInterrupcion {
 public static void main(String[] args) {
     System.out.println("Hilo Principal: Iniciando la aplicación.");

     HiloContador hiloTrabajador = new HiloContador("Contador-Infinito");
     hiloTrabajador.start(); // El HiloContador comienza a ejecutarse

     System.out.println("Hilo Principal: HiloContador iniciado. Esperando 5 segundos antes de interrumpir...");

     try {
         // El hilo principal duerme por 5 segundos
         Thread.sleep(5000);
     } catch (InterruptedException e) {
         System.err.println("Hilo Principal interrumpido inesperadamente.");
         Thread.currentThread().interrupt(); // Restaurar estado de interrupción
     }

     System.out.println("Hilo Principal: Han pasado 5 segundos. Enviando señal de interrupción al HiloContador.");
     hiloTrabajador.interrupt(); // Se envía la señal de interrupción al hilo trabajador

     // Opcionalmente, podríamos usar el método detener() si lo implementamos para una parada más "cooperativa"
     // además de la interrupción.
     // hiloTrabajador.detener();

     // Esperar a que el hilo trabajador termine (opcional, pero buena práctica si necesitas
     // asegurarte de que ha finalizado antes de que el main termine).
     try {
         hiloTrabajador.join(2000); // Espera hasta 2 segundos a que termine
         if (hiloTrabajador.isAlive()) {
             System.out.println("Hilo Principal: HiloContador todavía está vivo después del join. (Esto no debería pasar si la interrupción funcionó)");
         }
     } catch (InterruptedException e) {
         System.err.println("Hilo Principal interrumpido mientras esperaba al HiloContador.");
         Thread.currentThread().interrupt();
     }

     System.out.println("Hilo Principal: Finalizando la aplicación.");
 }
}