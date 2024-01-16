package u2e6AD;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class CercaText {

	public static void main(String[] args) throws IOException {
	    // Llegim el nom del fitxer de l'entrada estàndard
	    Scanner sc = new Scanner(System.in);

	    // Llegim el fitxer
	    File f = new File("src/u2e6AD/exemple.txt");
	    Scanner lector = new Scanner(f);

	    // Demanem la paraula o lletra a buscar
	    System.out.print("Paraula o lletra a buscar: ");
	    String cercar = sc.nextLine();

	    int lineNumber = 1;
	    boolean trobada = false; // Variable per fer un seguiment de si troba o no la paraula

	    
	    // Recorrem el fitxer línia a línia
	    while (lector.hasNextLine()) {
	        // Obtenim la línia actual
	        String linia = lector.nextLine();

	        // Cerquem la paraula o lletra a la línia actual
	        int posicio = linia.indexOf(cercar);

	        // Si la trobem, imprimim la línia y la posició
	        if (posicio != -1) {
	            System.out.println("Trobada a la línia " + lineNumber + " columna " + posicio);
	            trobada = true; // cancela el missatge de que no s'ha trobat
	        }

	        lineNumber++;
	    }

	    // si no s'ha trobat després del bucle mostrarà això
	    if (!trobada) {
	        System.out.println("No existeix res així dins el document");
	    }
	    

	    // Tancam el Scanner
	    lector.close();
	}
}
