import java.util.concurrent.Exchanger;

public class Productor extends Thread {
    private Exchanger<String> exchanger;

    public Productor (Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    public void run(){
        try{
            String item = "Datos del productor";
            System.out.println(Thread.currentThread().getName() + " produciendo " + item);

            String respuesta = exchanger.exchange(item);
            System.out.println(Thread.currentThread().getName() + " recibiendo " + respuesta);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
    }
}
