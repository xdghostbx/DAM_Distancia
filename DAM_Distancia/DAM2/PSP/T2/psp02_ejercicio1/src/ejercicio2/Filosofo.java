/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author USER
 */

import java.util.Random;


public class Filosofo implements Runnable {
    private int id;
    private Palillo [] palillo;
    
    int idPalilloIzq;
    int idPalilloDch;
    
    public Filosofo(int id, Palillo[] palillo) {
        this.id = id;
        this.palillo = palillo;
        this.idPalilloIzq = (id == 0) ? palillo.length - 1 : id - 1;
        this.idPalilloDch = (id) % palillo.length;
    }
    
    @Override
    public void run() {
        while (true){
            pensar();
            usarPalillo();
            comer();
            soltarPalillo();
        }
        
    }
    
    private void pensar(){
        System.out.println("Filosofo "+(int)(id+1)+" pensando");
        int tiempo = new Random().nextInt(10000)+1000; //que pueda esperar entre 1 y 10 segundos 
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            System.out.println("Error: "+ex);
        }
        
    }
    private void comer(){
        System.out.println("Filosofo "+(int)(id+1)+" comiendo");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    
    private void usarPalillo() {
    System.out.println("Filosofo " + (int)(id+1) + " tiene hambre");
    
    synchronized (this) { // Sincroniza el acceso a ambos palillos en un solo bloque
        palillo[idPalilloIzq].usar();
        palillo[idPalilloDch].usar();
    }
}
    
    private void soltarPalillo(){
        System.out.println("Filosofo "+ (int)(id+1) + " ha terminado de comer. Deja libre los palillos:" +(int)(idPalilloIzq+1)+" y "+(int)(idPalilloDch+1));
        synchronized (palillo[idPalilloIzq]) {
            palillo[idPalilloIzq].soltar();
            synchronized (palillo[idPalilloDch]) {
                palillo[idPalilloDch].soltar();
            }
        }
    }
    
}
