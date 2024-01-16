package u2e08;

public class Saldo_no_synchronized {
	public static void main(String[] args) {

		Cuenta_no_synchronized c = new Cuenta_no_synchronized(40);
		IngresarDinero_no_synchronized h1 = new IngresarDinero_no_synchronized("Ana", c);
		IngresarDinero_no_synchronized h2 = new IngresarDinero_no_synchronized("Juan", c);

		h1.start();
		h2.start();

	}
}
class Cuenta_no_synchronized {
	private int saldo ;

	Cuenta_no_synchronized (int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}

	void sumar(int cantidad){
		saldo+=cantidad;
	}

	
	
	 void IngresarDinero_no_synchronized(int cant, String nom) {	

		System.out.println(nom+": SE VA A INGRESAR SALDO (ACTUAL ES: "+getSaldo()+ ")" );
		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {	System.out.println(ex.getMessage());}

		sumar(cant);	

		System.out.println("\t"+nom+ " ingresa =>"+cant + " ACTUAL("+getSaldo()+")" );	


	}
}

class IngresarDinero_no_synchronized extends Thread {

	private Cuenta_no_synchronized c;	
	public IngresarDinero_no_synchronized(String n, Cuenta_no_synchronized c) {		
		super(n);
		this.c = c;
	}
	public  void run() {		
		for (int x = 1; x<= 4; x++) {		
			c.IngresarDinero_no_synchronized(10, getName());			
		}		
	}// run	
}

