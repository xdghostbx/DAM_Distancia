/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaConsumidores.ejemplo1;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Buffer datos = new Buffer();
        Productor productor = new Productor (datos, VelocidadAcceso.ALEATORIO);
        Consumidor consumidor = new Consumidor(datos, VelocidadAcceso.LENTO);
        productor.start();
        consumidor.start();
    }
    
}
