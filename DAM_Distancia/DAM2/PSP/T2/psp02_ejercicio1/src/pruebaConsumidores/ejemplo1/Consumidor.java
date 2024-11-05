/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaConsumidores.ejemplo1;

/**
 *
 * @author USER
 */
public class Consumidor extends Thread{
    Buffer buffer;
    VelocidadAcceso velocidad;

    public Consumidor(Buffer buffer, VelocidadAcceso velocidad) {
        this.buffer = buffer;
        this.velocidad = velocidad;
    }

    @Override
    public void run() {
        for (int i = 0; i<15; i++){
            try{
                buffer.get();
                sleep(velocidad.getMilisegundos());
            } catch (InterruptedException ex){
            }
        }
    }
    
    
}
