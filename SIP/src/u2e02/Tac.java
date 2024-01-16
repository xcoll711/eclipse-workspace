package u2e02;

public class Tac implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("TAC");
                Thread.sleep(777);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}