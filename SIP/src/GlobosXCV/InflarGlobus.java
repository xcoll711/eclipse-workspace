package GlobosXCV;

public class InflarGlobus extends Thread {
	private Globus g;  
	private int n;//num del Thread


	//CONSTRUCTOR
	public InflarGlobus(Globus g, int n) {
		this.g = g;                      
		this.n = n;         
		
		// assigna un nom a l'actual
		this.setName("IG" + n); 
	}

	// Mètode run, entrarà aqui cuan s'executi el fil
	@Override
	public void run() {
		int nGlobusActual;       
		
		// Indicarà si el globus explotarà o no
		boolean explota;
		

		while (true) {

			if ((nGlobusActual = g.donarGlobus()) == -1) {
				// Si no hi ha més globus surt
				break;  
			}


			do {
				try {
					Thread.sleep(1000);  
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt(); 
				}
				explota = g.inflar(nGlobusActual); // infla el globus actual i rebrà si explota o no
			} while (!explota);  // Repeteix el proxés fins que exploti
		}
	}
}
