import java.util.concurrent.Semaphore;

public class Parking implements Runnable {
    private Semaphore plazas;

    public Parking(int numPlazas) {
        this.plazas = new Semaphore(numPlazas);
    }

    public void aparcar(){
        try {
            plazas.acquire();
            System.out.println(Thread.currentThread().getName()+" aparcado");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salir(){
        try {
            Thread.sleep(2000);
            plazas.release();
            System.out.println(Thread.currentThread().getName()+" saliendo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        aparcar();
        salir();
    }
}
