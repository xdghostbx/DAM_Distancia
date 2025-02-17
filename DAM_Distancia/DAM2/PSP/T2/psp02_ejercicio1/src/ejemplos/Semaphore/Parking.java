/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Parking implements Runnable{
    Semaphore impresora;
    int cola;

    public Parking( int cola) {
        this.impresora = new Semaphore (cola);
        this.cola = cola;
    }
    
    public void entrar() throws InterruptedException{
        impresora.acquire();
        System.out.println("Proceso "+ Thread.currentThread().getName()+" usando la impresora"  );
        Thread.sleep(1000);
    }
    
    public void salir(){
        impresora.release();
        System.out.println("Preceso "+ Thread.currentThread().getName()+ " terminó de usar la impresora");
    }

    @Override
    public void run() {
        try {
            entrar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Parking.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            salir();
        }
    }
    
    
}
