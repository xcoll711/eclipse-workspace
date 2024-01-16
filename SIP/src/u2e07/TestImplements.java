package u2e07;

public class TestImplements {

	public static void main(String[] args) {
		
		
		Contador contador = new Contador();

		// Declaramos los hilos
		
		
        HiloExtends hilo1 = new HiloExtends(contador);
        HiloExtends hilo2 = new HiloExtends(contador);
        HiloExtends hilo3 = new HiloExtends(contador);
        HiloExtends hilo4 = new HiloExtends(contador);
        HiloExtends hilo5 = new HiloExtends(contador);

		
		
		        // Iniciamos los hilos
		        hilo1.start();
		        hilo2.start();
		        hilo3.start();
		        hilo4.start();
		        hilo5.start();

		// Esperamos a que terminen los hilos
		try {
			
			  hilo1.join();
			  hilo2.join(); 
			  hilo3.join();
			  hilo4.join();
			  hilo5.join();
			 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Imprimimos el valor final del contador
		System.out.println(contador.getContador());
	}

}

//implementamos Runnable para sincronizar
class HiloImplements implements Runnable {
    private Contador contador;

    public HiloImplements(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        synchronized (contador) {
            for (int i = 0; i < 5000; i++) {
                contador.incrementar();
            }
        }
    }
}

