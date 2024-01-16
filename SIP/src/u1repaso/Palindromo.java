package u1repaso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//cadena entrada estandar: cadena palindromo o vacia?
//segundo programa que ejecute el anterior. Debe leer por teclado.
//Transforma linea de archivo

public class Palindromo {

	public static void main(String[] args) {

		//recibe cadena del processbuilder
		String cadena = args [0];
		
		System.out.println(cadena);
		
		String alreves = "";
		System.out.println(cadena.length());
		for(int i = (cadena.length()-1); i != -1 ;i--) {
			System.out.println(cadena.charAt(i));
			alreves += (char) cadena.charAt(i);
			
		}

		System.out.println(alreves);

		


		// Leer el archivo de salida al final del proceso
		/*	try (BufferedReader br = new BufferedReader(new FileReader(fOut))) {
			String line;
			System.out.println(fOut.getName()+" --> ");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}


		} catch (IOException e) {
			System.out.println(e.getMessage());
		}*/

	}

}
