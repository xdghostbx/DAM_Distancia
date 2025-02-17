public class Incrementador extends Thread {
    private Contador contador;
    private int incrementos;

    public Incrementador(Contador contador, int incrementos) {
        this.contador = contador;
        this.incrementos = incrementos;
    }

    public void run() {
        for (int i = 0; i < incrementos; i++) {
            contador.incrementar();
        }
    }
}
