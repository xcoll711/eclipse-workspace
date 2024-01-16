package u2e7AD;

import java.io.*;

public class CodificacioArxius {

    public static void main(String[] args) {
    	
    	//Declaram els arxius i les seves rutes
        String arxiuEntrada = "src//u2e7AD//input.txt";
        String arxiuSortidaISO8859 = "src//u2e7AD//ISO8859-1.txt";
        String arxiuSortidaUTF16 = "src//u2e7AD//UTF-16.txt";

        //Declaram els Buffers amb el necessari per traduir la codificació 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arxiuEntrada), "UTF-8"));
             BufferedWriter bwISO88591 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arxiuSortidaISO8859), "ISO-8859-1"));
             BufferedWriter bwUTF16 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(arxiuSortidaUTF16), "UTF-16"))) {

            String linea;
            while ((linea = br.readLine()) != null) {
            	
                // escriure s'arxiu amb ISO-8859-1
                bwISO88591.write(linea);
                bwISO88591.newLine();

                // escriure s'arxiu UTF-16
                bwUTF16.write(linea);
                bwUTF16.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
