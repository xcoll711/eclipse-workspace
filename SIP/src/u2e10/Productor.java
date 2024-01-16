package u2e10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Productor extends Thread {

    private Cola cola; // Una cua on s'emmagatzemen els caràcters.
    private String fichero; // El fitxer que es llegeix per produir els caràcters.
    private int numConsum; // El nombre de consumidors que hi ha.

    public Productor(Cola c, String fichero, int numConsum) {
        this.cola = c;
        this.fichero = fichero;
        this.numConsum = numConsum;
    }

    /**
     * Llegeix el fitxer i produeix els caràcters un per un, posant-los a la cua.
     * Si s'arriba al final del fitxer, es posa un valor nul a la cua per cada consumidor.
     */
    @Override
    public synchronized void run() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fichero));
            String linea;

            while (true) {
                linea = br.readLine();

                if (linea != null) {
                    for (char caracter : linea.toCharArray()) {
                        String charString = String.valueOf(caracter);
                        cola.put(charString);
                        System.out.println("Productor produce --> " + charString);
                        // 0.1 sec de espera
                        Thread.sleep(100);
                    }
                } else {
                    for (int i = 0; i < this.numConsum; i++) {
                        cola.put(null);
                    }
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Productor ha finalizado.");
    }
}
