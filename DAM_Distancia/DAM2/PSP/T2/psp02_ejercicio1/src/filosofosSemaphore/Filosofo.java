/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filosofosSemaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;


/**
 *
 * @author USER
 */
public class Filosofo implements Runnable {
    private int id;
    Semaphore [] palillos;
    private int idPalilloIzq, idPalilloDch;

    public Filosofo(int id, Semaphore[] palillos, int idPalilloIzq, int idPalilloDch) {
        this.id = id;
        this.palillos = palillos;
        this.idPalilloIzq = id;
        this.idPalilloDch = (id+1)%5;
    }
    
    @Override
    public void run(){
        pensar();
        try {
            usarPalillo();
        } catch (InterruptedException ex) {
            System.out.println("Error: "+ex);
        }
        
        comer();
        soltarPalillo();
    }
    
    public void usarPalillo() throws InterruptedException {
        System.out.println("Filosodo "+(int)(id+1)+" tiene hambre");
        palillos[idPalilloIzq].acquire();
        palillos[idPalilloDch].acquire();  
    }
    
    public void soltarPalillo(){
        System.out.println("Filosofo " +(int)(id+1)+ " ha dejado de comer. "
                + "Deja libres los palillos: "+(int)(idPalilloIzq+1)+" y "
                + (int)(idPalilloDch+1));
        palillos[idPalilloIzq].release();
        palillos[idPalilloDch].release(); 
    }
    
    public void pensar(){
        System.out.println("Folosodo "+(int)(id+1)+ " pensado");
        int tiempo = new Random().nextInt(10000)+1000;
        try{
            Thread.sleep(tiempo);
        } catch (InterruptedException e){
        }
    }
    
    public void comer(){
        System.out.println("Filosodo "+(int)(id+1)+" comiendo");
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            System.out.println("Error: "+e);
        }
    }
}
