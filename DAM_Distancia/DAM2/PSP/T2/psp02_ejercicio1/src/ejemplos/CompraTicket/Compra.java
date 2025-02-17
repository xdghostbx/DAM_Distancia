/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.CompraTicket;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Compra extends Thread{
    Ticket ticket;
    int compra;
    Random random = new Random();
    public Compra(Ticket ticket, int compra) {
        this.ticket = ticket;
        this.compra = random.nextInt(10)+1;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( new Random().nextInt(5000)+1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (compra > ticket.getCantidad()){
            ticket.rellenarTickets();
            System.out.println("Se ha rellenado la cantidad de tickets, ahora hay "+ticket.getCantidad());
            for (int i = 0; i < compra; i++){
                ticket.venderTicket();
            }
            
        }else{
            for (int i = 0; i < compra; i++){
                ticket.venderTicket();
            }}
        System.out.println(Thread.currentThread().getName()+" ha comprado "+ compra+ " tickets, quedan "+ticket.getCantidad()+" tickets");
    }
    
    
}
