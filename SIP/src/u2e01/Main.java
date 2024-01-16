package u2e01;

/*Crea dos clases (hilos) Java que extiendan la clase Thread. 
 * Uno de los hilos debe visualizar en pantalla en un bucle 
 * infinito la palabra TIC y el otro hilo la palabra TAC.
 *  Dentro del bucle utiliza el método sleep() para que 
 *  nos de tiempo a ver las palabras que se visualizan cuando 
 *  lo ejecutemos, tendrás que añadir un bloque try-catch (para 
 *  capturar la excepción InterruptedException). Crea después la
 *   función main() que haga uso de los hilos anteriores. ¿Se 
 *   visualizan los textos TIC y TAC de forma ordenada (es decir 
 *   TIC TAC TIC TAC ...)? */

public class Main {

	public static void main(String[] args) {
		Tic tic = new Tic();
		Tac tac = new Tac();

		tic.start();
		tac.start();
	}


}
