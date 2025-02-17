/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.contadorErroneo;

/**
 *
 * @author USER
 */
public class Hilo extends Thread {
    final int NUM_INCREMENTOS=100;
    Contador contador;
    public Hilo(String nombre, Contador contador) {
        super(nombre);
        this.contador=contador;
    }
    @Override
    public void run () {
        //synchronized(contador){
            for(int i=0;i<NUM_INCREMENTOS;i++)
                    contador.incrementa();
        //} 
    }
}
