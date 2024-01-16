package u2e9AD;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class Main {
    public static void main(String[] args) {
        // Arrays de productes
        Producte[] productes = {
                new Producte(1, "Producte1", 10.5, true, 'A'),
                new Producte(2, "Producte2", 20.5, false, 'B'),
                new Producte(3, "Producte3", 15.5, true, 'C'),
                new Producte(4, "Producte4", 5.5, false, 'D'),
                new Producte(5, "Producte5", 12.37, true, 'E')
        };

        // Escriure els productes en un fitxer emprant RandomAccessFile
        try (RandomAccessFile raf = new RandomAccessFile("src//u2e9AD//productes.dat", "rw")) {
            for (Producte p : productes) {
                raf.writeInt(p.id);
                // Escriure el nom com a un nombre fix de caràcters (10 caràcters)
                raf.writeBytes(String.format("%-10s", p.nom));
                raf.writeDouble(p.preu);
                raf.writeBoolean(p.descompte);
                raf.writeChar(p.tipus);
            }

            // Llegir el segon registre (índex 1) utilitzant seek
            // Tots els tipus de valors emprats sumats (int + String + double + boolean + char) 
            // (25)  Segons diu el video
            raf.seek(25);

            int id = raf.readInt();
            byte[] nomBytes = new byte[10];
            raf.read(nomBytes);
            String nom = new String(nomBytes).trim();
            double preu = raf.readDouble();
            boolean descompte = raf.readBoolean();
            char tipus = raf.readChar();

            // Mostrar les dades del segon registre
            System.out.println("Segon registre:");
            System.out.println("ID: " + id);
            System.out.println("Nom: " + nom);
            System.out.println("Preu: " + preu);
            System.out.println("Descompte: " + descompte);
            System.out.println("Tipus: " + tipus);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}