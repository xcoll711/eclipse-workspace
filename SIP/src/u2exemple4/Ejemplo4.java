package u2exemple4;
import java.io.*;

public class Ejemplo4 {

	public static void main(String[] args) throws IOException{

		Process p = new ProcessBuilder("CMD", "/C", "DATE").start();
		
		//escritura -- envia entrada a DATE
		OutputStream os = p.getOutputStream();
		os.write("03-10-2023".getBytes());
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
