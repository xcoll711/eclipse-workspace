/*Crear un programa que permita parametrizar el lanzamiento de sumadores,
que vuelque el contenido de las sumas en ficheros y que permita al
programa principal recuperar las sumas de los ficheros parciales.*/


/*iNCLUYE 1.7*/


/*INCLUYE 1.8 : Usando ProcessBuilder.Redirect, modifica el Ejemplo5.java para que la salida 
 * del proceso se muestre en la consola, la entrada la tome desde un fichero de texto, y la 
 * salida la lleve a un fichero de texto. */


package ejercicioSumadoresYFicheros;

import java.io.*;

public class Lanzador {

	public static void main(String[] args) throws IOException {

		//RUTA RELATIVA DEL SUMADOR
		ProcessBuilder pb = new ProcessBuilder("java","src/ejercicioSumadoresYFicheros/Sumador2.java");



		//afegit 1.7 --> es necessita un fitxer de text anomenat entrada.txt amb 2 nombres 
		File fIn = new File ("entrada.txt");

		//ESCRIBIRÁ AQUI
		File fOut = new File ("salida.txt");
		File fErr = new File ("error.txt");



		pb.redirectInput (ProcessBuilder.Redirect.from(fIn)); 
		pb.redirectOutput (ProcessBuilder.Redirect.appendTo (fOut)); 
		pb.redirectError (ProcessBuilder.Redirect.appendTo(fErr)); 

		Process p = pb.start();





		/*//escritura 
		OutputStream os = p.getOutputStream();
		os.write("50\n".getBytes());
		os.write("37\n".getBytes());
		os.flush();*/


		//COMPROBACIÓN ERROR -> 0 BIEN, 1 MAL
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor salida: "+ exitVal);
		}catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}

		// Leer el archivo de salida al final del proceso
		try (BufferedReader br = new BufferedReader(new FileReader(fOut))) {
			String line;
			System.out.println("salida.txt :");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}


	}

}
