package u2exemple8SynchronizedMethod;

public class SynchronizedMethod {


	public static void main(String[] args) {
		Contador cont = new Contador(100);
		HiloA a = new HiloA("HiloA", cont);
		HiloB b = new HiloB("HiloB", cont);
		a.start();
		b.start();
	}
}

class Contador {
	private int c = 0;

	Contador(int c) {
		this.c = c;
	}

	public synchronized void incrementa() {
		c++;
	}

	public synchronized void decrementa() {
		c--;
	}

	public synchronized int getValor() {
		return c;
	}
}

class HiloA extends Thread {
	private Contador contador;

	public HiloA(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {

		for (int j = 0; j < 300; j++) {
			contador.incrementa();


		}
		try {

			System.out.println(getName() + " contador vale " + contador.getValor());

		}catch(Exception e) {

		}

	}

}

class HiloB extends Thread {
	private Contador contador;

	public HiloB(String n, Contador c) {
		setName(n);
		contador = c;
	}

	public void run() {


		for (int j = 0; j < 300; j++) {
			contador.decrementa();


		}
		try {

			System.out.println(getName() + " contador vale " + contador.getValor());

		}catch(Exception e) {

		}
	}

}



