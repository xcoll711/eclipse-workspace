package u2e07;

public class Contador {

    private int contador = 0;

    
    public synchronized void incrementar() {
            contador++;
        
    }

    public int getContador() {
        return contador;
    }


}

