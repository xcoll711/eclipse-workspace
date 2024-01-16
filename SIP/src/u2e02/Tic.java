package u2e02;

public class Tic implements Runnable {

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
