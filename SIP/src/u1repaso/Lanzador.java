package u1repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Lanzador {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		System.out.println("Intorduzca cadena");
		String cadena = sc.next();
		
		ProcessBuilder pb1 = new ProcessBuilder("java","src/u1repaso/Palindromo.java",cadena);

		try {
			Process p1 = pb1.start();
			
			InputStream is = p1.getInputStream();

			int c;
			String result ="";
			while((c = is.read()) != -1) {
				result += (char)c;
			}
			
			
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		File fOut = new File("src/u1repaso/output.txt");
		pb1.redirectOutput (ProcessBuilder.Redirect.appendTo (fOut)); 

		
		


	




	}
}
