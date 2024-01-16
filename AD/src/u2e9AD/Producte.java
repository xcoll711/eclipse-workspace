package u2e9AD;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.IOException;

class Producte {
    int id;
    String nom;
    double preu;
    boolean descompte;
    char tipus;

    public Producte(int id, String nom, double preu, boolean descompte, char tipus) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.descompte = descompte;
        this.tipus = tipus;
    }
}