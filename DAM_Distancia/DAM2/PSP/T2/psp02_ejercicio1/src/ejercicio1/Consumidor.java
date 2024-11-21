/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.Random;

/**
 *
 * @author USER
 */

import java.util.concurrent.BlockingQueue;


public class Consumidor implements Runnable {
    private BlockingQueue<Character> cola;
    private int numProductos;
    Random aleatorio = new Random();
    
    public Consumidor (BlockingQueue<Character> cola, int numProductos){
        this.cola = cola;
        this.numProductos = numProductos;
    }
    
    @Override
    public void run(){
        try{
            for (int i = 0; i<numProductos;i++){
                Thread.sleep(aleatorio.nextInt(1000)+10); 
                Character ch = cola.take();
                System.out.println("Consumiendo: "+ch);
                
            }
            
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
