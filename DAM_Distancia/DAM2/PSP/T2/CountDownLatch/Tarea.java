import java.util.concurrent.CountDownLatch;

public class Tarea extends Thread {
    private CountDownLatch latch;

    public Tarea (CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " trabajando...");
            Thread.sleep(2000);
        } catch (InterruptedException e){

        } finally {
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " ha terminado.");
        }
    }
}
