package RecursosXCV;

import java.io.IOException;


public class Test {
	 public static void main(String[] args) throws IOException, InterruptedException {

		 System.out.println(" Hola Natxo, el següent programa assignarà 10 unitats a cada procés \n "
		 		+ "Competiràn per emprar el recurs de reservar i alliberar les seves unitats aleatoriament. \n");
	        int k = 10; // nombre de unitats del recurs
	        int n = 5; // nombre de processos


	        Recurs recurs = new Recurs(k);


	        Thread[] processos = new Thread[n];
	        for (int i = 0; i < n; i++) {
	            processos[i] = new Thread(new ReservaIAllibera(recurs, (int) (Math.random() * k), (int) (Math.random() * k)));
	        }

	        // iniciem els processos
	        for (int i = 0; i < n; i++) {
	            processos[i].start();
	        }

	        // esperam que els processos acabin
	        for (int i = 0; i < n; i++) {
	            processos[i].join();
	        }

	        System.out.println("Funciona");
	    }
}
