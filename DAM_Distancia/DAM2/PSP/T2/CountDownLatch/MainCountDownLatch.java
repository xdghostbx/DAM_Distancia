import java.util.concurrent.CountDownLatch;

public class MainCountDownLatch {
    public static void main(String[] args) {
        int numTareas = 3;
        CountDownLatch latch = new CountDownLatch(numTareas); 

        for (int i = 0; i < numTareas; i++) {
            new Tarea(latch).start();
        }

        try {
            latch.await();
            System.out.println("Todas las tareas han terminado.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
