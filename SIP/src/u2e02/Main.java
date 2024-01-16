package u2e02;

/*Transforma el Ejercicio 1 usando la interfaz Runnable 
 * para declarar el hilo. Después realiza el programa 
 * Java que pide el enunciado del ejercicio.  */

public class Main {

	public static void main(String[] args) {
		Tic tic = new Tic();
		Tac tac = new Tac();

	    new Thread(tic).start();
	    new Thread(tac).start();

	}


}
