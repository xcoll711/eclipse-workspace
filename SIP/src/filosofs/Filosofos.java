package filosofs;


public class Filosofos implements Runnable {

    private Cubiertos cubiertos;
    private int filosofo;
 

    public Filosofos(Cubiertos m, int filosofo) {
        this.cubiertos = m;
        this.filosofo = filosofo;
    
    }

    @Override
    public void run() {
        String miNombre = "Filosofo " + filosofo;

        while (true) {
            /* Comer */
            cubiertos.cogerTenedores(filosofo - 1);
            System.out.println(miNombre + " comiendo...");
            esperarTiempoAzar(miNombre, (int) (1000 + Math.random() * 4000));

            /* Pensar y soltar cubiertos */
            cubiertos.dejarTenedores(filosofo - 1);
            System.out.println(miNombre + " está pensando...");
            esperarTiempoAzar(miNombre, (int) (1000 + Math.random() * 4000));
        }
    }

    private void esperarTiempoAzar(String miNombre, int milisegs) {
        try {
            Thread.sleep(milisegs);
        } catch (InterruptedException e) {
            System.out.println(miNombre + " interrumpido!!. Saliendo...");
            Thread.currentThread().interrupt();
        }
    }
}
