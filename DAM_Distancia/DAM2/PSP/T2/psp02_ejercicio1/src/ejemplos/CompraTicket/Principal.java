/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.CompraTicket;

import java.util.Random;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroTickets = 100, numeroHilos = 50;
        Ticket ticket = new Ticket (100);
        Thread[] hilos = new Thread[numeroHilos];
        
        for (int i = 0; i<numeroHilos; i++){
            hilos[i] = new Thread(new Compra (ticket, new Random().nextInt(10)+1 ),"hilo"+i);
            hilos[i].start();
        }
        
        for (int i = 0; i<numeroHilos; i++){
            try {
                hilos[i].join();
            } catch (InterruptedException e){}
        }
    }
    
}
