package barberos;
import java.util.Random;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int MAX_BARBEROS = 4;
        int MAX_SILLAS   = 3;
        int MAX_CLIENTES = 100;
        Barbero[] barberos;
        Thread[] hilos;

        barberos = new Barbero[MAX_BARBEROS];
        hilos    = new Thread[MAX_BARBEROS];

        Sillas sillas = new Sillas(MAX_SILLAS);

        for (int i = 0; i < MAX_BARBEROS; i++) {
            barberos[i] = new Barbero(sillas);  // Debes asignar la instancia de Sillas a cada Barbero
            hilos[i]    = new Thread(barberos[i]);
            hilos[i].start();
        }

        int i = 0;
        while(true) {
            Cliente c = new Cliente(i, sillas);
            i++;
            c.entrarEnBarberia();
            
        }
       // Barbero.esperarTiempoAzar(30);
    }
}
