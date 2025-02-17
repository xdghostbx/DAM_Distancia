package biblioteca;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Biblioteca implements Runnable {
    Semaphore sillas;
    Random aleatorio = new Random();

    public Biblioteca(Semaphore sillas) {
        this.sillas = sillas;
    }

    public void entrar() throws InterruptedException {
        if(sillas.availablePermits() == 0){
            System.out.println("No hay sillas libres,{"+Thread.currentThread().getName()+"}"+" está esperando.");
        }
        sillas.acquire();
        System.out.println("{"+Thread.currentThread().getName()+"}"+" ha llegado y está leyendo en una silla.");
        
    }

    public void salir() {
        
        System.out.println("{"+Thread.currentThread().getName()+"}"+" ha terminado de leer y ha liberado una silla.");
        sillas.release();
    }


    @Override
    public void run() {
        try {
            while(true){
                Thread.sleep(aleatorio.nextInt(1000)+500);  
                entrar();
                Thread.sleep((aleatorio.nextInt(5000)+2500));  
                salir();
            }
        } catch (Exception e) {
            System.out.println("Error al entrar en la biblioteca");
        }
    }
}
