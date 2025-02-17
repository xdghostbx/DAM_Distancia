import java.util.concurrent.Exchanger;

class Consumidor extends Thread {
    private Exchanger<String> exchanger;

    public Consumidor(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run() {
        try {
            String item = "Datos del consumidor";
            String recibido = exchanger.exchange(item); // Intercambio de datos
            System.out.println(Thread.currentThread().getName() + " recibió: " + recibido);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
