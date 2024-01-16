package u2e11;

public class Arbitre {

    private final int jugadors;
    private final int numero;
    private int torn;
    private boolean terminado;

    public Arbitre(int jugadores) {
        this.jugadors = jugadores;
        this.numero = generaNumero();
        this.torn = 1;
        this.terminado = false;
    }

    private synchronized int generaNumero() {
        int num = 1 + (int) (10 * Math.random());
        
        System.out.println("NÚMERO A ADIVINAR: " + num);
        return num;
    }

 

    public synchronized void comprovar(int n) {
        if (numero == n) {
            terminado = true;
            System.out.println("\tEl jugador " + torn + " guanya!");
        } else {
            torn = seguentTorn();
            System.out.println("\tTorn del jugador " + torn);
        }
    }
    
    public synchronized int getTorn() {
        return torn;
    }

    private int seguentTorn() {
        if (torn == jugadors) {
            return 1;
        } else {
            return torn + 1;
        }
    }

    public synchronized boolean jocAcabat() {
        return terminado;
    }

}
