package u2e10;

public class Cola {
    private String producto; // El producte que es guarda a la cua.
    private boolean disponible = false;//inicialmente cola vacia

    public synchronized String get() { // Retorna el producte que es troba a la cua.
    	  while (!disponible) { // Si la cua està buida, el mètode es bloqueja fins que es posi un producte a la cua.
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }

    	  disponible = false; 
    	  notifyAll(); // Notifica a tots els fils que estan esperant per accedir a la cua.
    	  return producto; 
    	}


    public synchronized void put(String valor) { // Posa el valor especificat a la cua.
    	  while (disponible){ // Si la cua ja té un producte, el mètode es bloqueja fins que es retiri el producte de la cua.
    	    try {
    	          wait();
    	    } catch (InterruptedException e) { }
    	  }
    	  producto = valor; // Posa el valor a la cua.
    	  disponible = true; // Marca la cua com a disponible.

    	  notifyAll(); // Notifica a tots els fils que estan esperant per accedir a la cua.
    	}

     
     
}
