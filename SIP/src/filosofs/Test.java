package filosofs;

public class Test {
    
    public static void main(String[] args) {
        Cubiertos m = new Cubiertos(5);
        for (int i = 1; i <= 5; i++) {
            Filosofos filosofo = new Filosofos(m, i);
            Thread hiloFilosofo = new Thread(filosofo);
            hiloFilosofo.start();
        }
    }
}