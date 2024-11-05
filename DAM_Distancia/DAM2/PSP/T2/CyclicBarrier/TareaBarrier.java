import java.util.concurrent.CyclicBarrier;

public class TareaBarrier extends Thread {
    private CyclicBarrier barrera;

    public TareaBarrier(CyclicBarrier barrera) {
        this.barrera = barrera;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " trabajando...");
            Thread.sleep(2000);
            
            barrera.await();
            System.out.println(Thread.currentThread().getName() + " continuando.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
