package u2e01;

public class Tic extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("TIC");
                Thread.sleep(777);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
