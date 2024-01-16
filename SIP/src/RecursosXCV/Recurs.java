package RecursosXCV;

public class Recurs {
	private int k; // nombre de unitats del recurs
	private int disponibles; // unitats disponibles

	public Recurs(int k) {
		this.k = k;
		this.disponibles = k;
	}

	public synchronized void reserva(int r) {

		// mira si hi ha prou unitats disponibles per reservar
		while (r > disponibles) {
			try {
				wait(); // Esperar fins que hi hagi prou unitats disponibles
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		// Realitzar la reserva
		disponibles -= r;
		System.out.println(Thread.currentThread().getName() + " ha reservat " + r + " unitats. Unitats disponibles: " + disponibles);

		// Notifica als altres processos 
		notifyAll();
	}

	public synchronized void allibera(int a) {


		disponibles += a;
		System.out.println(Thread.currentThread().getName() + " ha alliberat " + a + " unitats. Unitats disponibles: " + disponibles);

		// Notifica als altres processos de que ha acabat
		notifyAll();
	}
}