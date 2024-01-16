package u2exemple4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class LanzadorLeerNombre2 {
	public static void main(String[] args) throws IOException {

		// Creamos un objeto File al directorio donde está Ejemplo2
		File directorio = new File("C:\\Users\\ciclesgs.EAAULA211W-024\\eclipse-workspace\\SIP\\src\\exemple4");

		// Creamos el proceso añadiendo "nombre" que irá a args[0] en este caso
		ProcessBuilder pb = new ProcessBuilder("java", "LeerNombre.java");
		pb.directory(directorio);
		System.out.printf("*Directorio de trabajo: %s%n", pb.directory());

		Process p = pb.start();
		System.out.println("*Se ejecuta el proceso");

		//escritura -- envia entrada a DATE
		OutputStream os = p.getOutputStream();
		os.write("Xavi\n".getBytes());
		os.flush(); // vacia el buffer de salida

		//lectura 
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();

		//COMPROBACIÓN ERROR -> 0 BIEN, 1 MAL
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor salida: "+ exitVal);
		}catch(InterruptedException e) {

		}
	}
}
