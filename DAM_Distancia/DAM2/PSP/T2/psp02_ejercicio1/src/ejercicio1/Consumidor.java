/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author USER
 */

import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {
    private BlockingQueue<Character> cola;
    private int numProductos;
    
    public Consumidor (BlockingQueue<Character> cola, int numProductos){
        this.cola = cola;
        this.numProductos = numProductos;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i<numProductos;i++){
                Thread.sleep(250);
                Character ch = cola.take();
                System.out.println("Consumiendo: "+ch);
                
            }
            
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
