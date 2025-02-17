/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filosofosSemaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numFilosofos = 5;
        Semaphore [] palillos = new Semaphore[numFilosofos];
        
         
        for(int i = 0; i < numFilosofos; i++){
            palillos[i] = new Semaphore(1);
        }
        
        for (int i = 0; i < numFilosofos; i++){
            int idIzq = i;
            int idDch = (i+i) % numFilosofos;
            
            Filosofo filosofo = new Filosofo ( i, palillos, idIzq, idDch);
            Thread hilo = new Thread(filosofo, "Filosofo "+i);
            hilo.start();
        }
    }
    
}
