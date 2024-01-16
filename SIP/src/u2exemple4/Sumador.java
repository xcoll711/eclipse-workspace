package u2exemple4;

import java.util.Scanner;

public class Sumador {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		System.out.println("--Primer num:");
		int n1 = sc.nextInt();
		System.out.println(n1);
		
		System.out.println("--Segon num:");
		int n2 = sc.nextInt();
		System.out.println(n2);
		
		
		System.out.println("Resultat "+(n1 + n2));
		
	}

}
