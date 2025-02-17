import java.util.concurrent.CyclicBarrier;

public class MainCyclicBarrier {
    public static void main(String[] args) {
        int numTareas = 3;
        CyclicBarrier barrera = new CyclicBarrier(numTareas , new Runnable() {
            @Override
            public void run() {
                System.out.println("Todas las tareas han terminado.");
            }
        });
        
        for (int i = 0; i < numTareas; i++) {
            new TareaBarrier(barrera).start();
            
        }

        
    }
}
