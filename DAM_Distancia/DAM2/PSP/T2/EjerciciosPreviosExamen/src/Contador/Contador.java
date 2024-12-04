package Contador;

public class Contador implements Runnable {
    private int count;
    private int incrementos;

    public Contador (int count, int incrementos) {
        this.count = count;
        this.incrementos = incrementos;
    }
    public synchronized void incrementar() {
        for (int i = 0; i < incrementos; i++){
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        incrementar();
    }
}
