package u2e01;

public class Tac extends Thread {

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