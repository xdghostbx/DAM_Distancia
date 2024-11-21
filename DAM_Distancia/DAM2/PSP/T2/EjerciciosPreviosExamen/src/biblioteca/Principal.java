package biblioteca;

import java.util.concurrent.Semaphore;

public class Principal {
    static int numSillas = 4;
    public static Biblioteca biblioteca = new Biblioteca (new Semaphore(numSillas));
    

    public static void main(String[] args) {
        Thread lector1 = new Thread(biblioteca, "Lector 1");
        Thread lector2 = new Thread(biblioteca, "Lector 2");
        Thread lector3 = new Thread(biblioteca, "Lector 3");
        Thread lector4 = new Thread(biblioteca, "Lector 4");
        Thread lector5 = new Thread(biblioteca, "Lector 5");
        Thread lector6 = new Thread(biblioteca, "Lector 6");
        Thread lector7 = new Thread(biblioteca, "Lector 7");

        lector1.start();
        lector2.start();
        lector3.start();
        lector4.start();
        lector5.start();
        lector6.start();
        lector7.start();
    

    }
}
