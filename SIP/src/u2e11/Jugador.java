package u2e11;

public class Jugador extends Thread {
	
	private Arbitre arbitre;
	private int id;
	
	public Jugador(Arbitre a, int id) {
		arbitre = a;
		this.id = id;
	}
	
	public void run() {
		while(!arbitre.jocAcabat()) {
			if(arbitre.getTorn() == this.id) {
				int num = 1 + (int)(10 * Math.random());
				System.out.println("Jugador " + this.id + " diu: " + num);
				arbitre.comprovar(num);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
