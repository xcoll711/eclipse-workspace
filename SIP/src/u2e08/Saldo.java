package u2e08;

public class Saldo {
	public static void main(String[] args) {

		Cuenta c = new Cuenta(40);
		IngresarDinero h1 = new IngresarDinero("Ana", c);
		IngresarDinero h2 = new IngresarDinero("Juan", c);

		h1.start();
		h2.start();

	}
}
class Cuenta {
	private int saldo ;

	Cuenta (int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}

	void sumar(int cantidad){
		saldo+=cantidad;
	}

	
	
	synchronized void IngresarDinero(int cant, String nom) {	

		System.out.println(nom+": SE VA A INGRESAR SALDO (ACTUAL ES: "+getSaldo()+ ")" );
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {	System.out.println(ex.getMessage());}

		sumar(cant);	

		System.out.println("\t"+nom+ " ingresa =>"+cant + " ACTUAL("+getSaldo()+")" );	


	}
}

class IngresarDinero extends Thread {

	private Cuenta c;	
	public IngresarDinero(String n, Cuenta c) {		
		super(n);
		this.c = c;
	}
	public  void run() {		
		for (int x = 1; x<= 4; x++) {		
			c.IngresarDinero(10, getName());			
		}		
	}// run	
}

