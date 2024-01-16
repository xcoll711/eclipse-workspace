package u2e04;

class MyHilo extends Thread {

    int contador = 0;

    
    private SolicitaSuspender suspender = new SolicitaSuspender();

    // petición de SUSPENDER HILO
    public void Suspende() {
        suspender.set(true);
    }

    // petición de CONTINUAR
    public void Reanuda() {
        suspender.set(false);
    }

    // mètode per enviar el contador a la classe Test
    public int getContador() {
        return contador;
    }

    public void run() {
        try {
        	// bucle infinit de suma de contador cada 7.77s
        	// 
            while (true) {
                contador++;
                System.out.println(contador);
                Thread.sleep(777);

                
                suspender.esperandoParaReanudar();
            }

        } catch (InterruptedException e) {
        	// per haver posat això al final de tot el bucle quan poso * envia un "sleep interrupted" com a error
        	System.out.println(e.getMessage());
        }
        
        System.out.println("Hilo finalizado");
    }
}
