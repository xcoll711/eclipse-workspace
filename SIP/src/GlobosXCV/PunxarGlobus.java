package GlobosXCV;

public class PunxarGlobus extends Thread {
    private Globus g;
    private int n;

    public PunxarGlobus(Globus g, int n) {
        this.g = g;
        this.n = n;
        setName("PG" + n);
    }

    @Override
    public void run() {
        while (true) {
            try {
            	
            	//Ens assegurem de que sigui com a mínim 1 segon
            	long tempsAleatori = (long) (Math.random() * 10000);
            	if (tempsAleatori < 1000) {
            		tempsAleatori = 1000;
            	}
            	
            	
                Thread.sleep(tempsAleatori);
            } catch (InterruptedException e) {
            	System.out.println(e.getMessage());
            }

            // ens asseguram de que no hi hagi problemes de concurrencia
            synchronized (g) {
                if (!g.punxar()) {
                    break;
                }
            }
        }
    }

}







