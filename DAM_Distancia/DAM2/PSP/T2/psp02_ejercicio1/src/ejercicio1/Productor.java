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
import java.util.Random;

public class Productor implements Runnable {
    private BlockingQueue <Character> cola;
    private int numProductos;
    Random aleatorio = new Random();
    
    public Productor (BlockingQueue<Character> cola, int numProductos){
        this.cola = cola;
        this.numProductos = numProductos;
    }
    
    @Override
    public void run(){
        try{
            char [] letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
            
            
            for (int i = 0; i < numProductos; i++){
                int indice = aleatorio.nextInt(letras.length);
                char letraAleatoria = letras[indice];
                cola.put(letraAleatoria);
                System.out.println("Produciendo: "+letraAleatoria);
                Thread.sleep(100);                
            }  
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
