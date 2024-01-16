package u2e10;

import java.util.*;

public class Produc_Consum {
    public static void main (String [] args) throws InterruptedException{
        Cola cola = new Cola();

        // Crea dos consumidors.
        Consumidor c1 = new Consumidor(cola, 1);
        Consumidor c2 = new Consumidor(cola, 2);

        // Crea una llista per ficar tots els consumidors.
        List<Consumidor> consumidores = new ArrayList<>();
        consumidores.add(c1);
        consumidores.add(c2);

        // Crea un productor que llegeix el fitxer "arxiu.txt".
        Productor p = new Productor(cola, "src\\u2e10\\arxiu.txt", consumidores.size());

        // Inicia el productor i els consumidors.
        p.start();
        c1.start();
        c2.start();

        // Espera que el productor i els consumidors finalitzin.
        p.join();
        c1.join();
        c2.join();

        // Imprimeix l'estat dels consumidors.
        System.out.println("Estado consumidor 1 : " + c1.getState());
        System.out.println("Estado consumidor 2 : " + c2.getState());
    }
}
