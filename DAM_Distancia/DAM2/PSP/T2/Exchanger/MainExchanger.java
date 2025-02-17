import java.util.concurrent.Exchanger;

public class MainExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Productor(exchanger).start();
        new Consumidor(exchanger).start();
    }
}
