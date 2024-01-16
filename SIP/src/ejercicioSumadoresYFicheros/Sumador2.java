package ejercicioSumadoresYFicheros;

import java.util.Scanner;

public class Sumador2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Scanners per a rebre lo de OutputStream
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		//Tots els sysos del document s'escriuran a salida.txt
		System.out.println(n1 + " + " +  n2 + " = "+(n1 + n2));

	}
}
