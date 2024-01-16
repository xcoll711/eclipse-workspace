package u2e11;

public class Main {

	public static void main(String[] args) {
		
		Arbitre a = new Arbitre(3);
		
		Jugador j1 = new Jugador(a, 1);
		Jugador j2 = new Jugador(a, 2);
		Jugador j3 = new Jugador(a, 3);
		
		j1.start();
		j2.start();
		j3.start();

	}

}
