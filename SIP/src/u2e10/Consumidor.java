package u2e10;

public class Consumidor extends Thread {
	private Cola cola;
	private int n;

	public Consumidor(Cola c, int n) {
		cola = c;
		this.n = n;
	}

	public synchronized void run() { // El mètode run() s'executa quan s'inicia el consumidor.
		String valor;
		while (true) { // Repeteix aquet bucle fins que la cua estigui buida.
			valor = cola.get(); // Obté el producte de la cola.
			if (valor == null) { // Si el producte és nul, el consumidor finaliza.
				break;
			}
			System.out.println("Consumidor: " + n + ", consume: " + valor); // Imprimeix el producte en la consola.
			try {
				sleep(100); // Espera 100 milisegons.
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Consumidor " + n + " ha finalizado."); // Imprimeix un missatge indicant que el consumidor ha finalizat.
	}
}
