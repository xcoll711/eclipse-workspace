package u2e8AD;

import java.io.*;

public class VolcadoBinario {

	static int TAM_FILA = 32;
	static int MAX_BYTES = 2048;

	// Objecte PrintStream per escriure les dades volcades
	PrintStream out = null;

	public VolcadoBinario(PrintStream out) {
		this.out = out;
	}

	  public void volcar(InputStream is) throws IOException {
		  // Buffer per emmagatzemar les dades llegides
	        byte buffer[] = new byte[TAM_FILA]; 
	     // Per emmagatzemar el nombre de bytes llegits
	        int bytesLlegits;  

	        int offset = 0;  

	        do {
	            bytesLlegits = is.read(buffer);  // Llegeix una fila de dades a partir de InputStream
	            out.format("[%5d]", offset);  // Escriu l'offset actual en el format "[%5d]"

	            // Recorre el buffer i escriu cada byte en format hexadecimal
	            for (int i = 0; i < bytesLlegits; i++) {
	                out.format(" %2x", buffer[i]);
	            }

	            offset += bytesLlegits;  // Actualitza l'offset amb el nombre de bytes llegits
	            out.println();  // Salta una línia després de cada fila de dades

	        } while (bytesLlegits == TAM_FILA && offset < MAX_BYTES);  // Continua fins que es llegeixqui tot
	    }

	public static void main(String[] args) {
		
	
		// Obre un FileInputStream i un FileOuput amb el nom dels fitxer
		try (FileInputStream fis = new FileInputStream("src//u2e8AD//"+"input.txt");
				FileOutputStream fos = new FileOutputStream("src//u2e8AD//"+"output.txt");
				// Crea un PrintStream per escriure al fitxer de sortida
				PrintStream ps = new PrintStream(fos)) {
			
			 // Crea un objecte VolcadoBinario amb el PrintStream com a sortida
			VolcadoBinario vb = new VolcadoBinario(ps);
			// Fa el volcat des de l'arxiu input al PrintStream
			vb.volcar(fis);
			
			//Exceptions
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no existeix el fitxer");
		} catch (IOException e) {
			System.err.println("ERROR de E/S: " + e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
