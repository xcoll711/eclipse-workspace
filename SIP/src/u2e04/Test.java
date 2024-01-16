package u2e04;

import java.util.*;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);

        String t;
        
        //Creamos un objeto MyHilo y lo iniciamos
        MyHilo hilo = new MyHilo();
        hilo.start();

        //mentres no escrigui * mostrarà aquest text per cada cosa que hi fiquem. 
        // Si escrivim s o r cridarà als mètodes de MyHilo.
        do {
            System.out.println("Introduce S para suspender el hilo, R para reanudarlo o * para terminar");
           t = sc.nextLine();

            switch (t) {
                case "s":
                    hilo.Suspende();
                    break;
                case "r":
                    hilo.Reanuda();
                    break;
              
            }

        } while (!t.equals("*"));

        System.out.println("És contador val " + hilo.getContador());
        
        //hilo.stop();
        hilo.interrupt();
	}

}
