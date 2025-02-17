package Contador;

public class Main {
    public static void main(String[] args) {
        int incrementos = 1000;
        int total = 0;
        Contador contador = new Contador(total, incrementos);

        Thread hilo1 = new Thread(contador);
        Thread hilo2 = new Thread(contador);
        Thread hilo3 = new Thread(contador);

        hilo1.start();
        hilo2.start();
        hilo3.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El total es: " + contador.getCount());
    }
}
