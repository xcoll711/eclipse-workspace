package u2e5AD;

import java.io.*;
import java.util.*;

public class Test {



	    public static void main(String[] args) throws IOException {

	        // Try catch resources tot junt
	        try (BufferedReader lector = new BufferedReader(new FileReader("src\\u2e5AD\\original.txt"));
	            BufferedWriter escritor = new BufferedWriter(new FileWriter("src\\u2e5AD\\modificat.txt"))
	        ) {
	            // llegeix les linies de l'arxiu original i les fica a l'arraylist
	            ArrayList<String> linies = new ArrayList<>();
	            String linea;
	            while ((linea = lector.readLine()) != null) {
	                linies.add(linea);
	            }

	            // Afageix la linea que falta a l'arraylist en la segona posició
	            linies.add(1, "Això és la segona linia.");

	            // escriu la resta de linies (i es salta la segona posició perque està ocupada)
	            for (String l : linies) {
	                escritor.write(l + "\n");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}




