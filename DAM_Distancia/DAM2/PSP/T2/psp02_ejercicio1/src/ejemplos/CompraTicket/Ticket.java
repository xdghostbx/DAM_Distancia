/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.CompraTicket;

/**
 *
 * @author USER
 */
public class Ticket {
    private int cantidad;

    public Ticket(int cantidad) {
        this.cantidad = cantidad;
    }

    public synchronized int getCantidad() {
        return cantidad;
    }
    
    public synchronized int venderTicket(){
        cantidad--;
        return cantidad;
    }
    
    public synchronized int rellenarTickets(){
        cantidad += 100;
        return cantidad;
    }
}
