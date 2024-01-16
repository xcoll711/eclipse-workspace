package barberos;

import java.util.Random;

public class Barbero implements Runnable {
    Sillas sillas;

    public Barbero(Sillas s) {
        sillas = s;
    }

    @Override
    public void run() {
        while (true) {
            int posSillaClienteSinAtender = this.sillas.getSiguienteCliente();

            if (posSillaClienteSinAtender == -1) {
                System.out.println("Barbero espera un cliente.");
                esperarTiempoAzar(3);
            } else {
                System.out.println("Barbero atiende a Cliente en Silla " + posSillaClienteSinAtender);
                esperarTiempoAzar(3);
                this.sillas.liberarSilla(posSillaClienteSinAtender);
            }
        }
    }

    public static void esperarTiempoAzar(int max) {
        Random generador = new Random();
        int msAzar = (1 + generador.nextInt(max)) * 1000;
        try {
            Thread.sleep(msAzar);
        } catch (InterruptedException e) {
            System.out.println("Fallo la espera");
        }
    }
}
