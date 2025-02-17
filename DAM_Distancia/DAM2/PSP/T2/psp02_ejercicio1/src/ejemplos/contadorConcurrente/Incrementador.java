/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.contadorConcurrente;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Incrementador implements Runnable{
    
    int incrementos;
    Contador contador = new Contador();

    public Incrementador(Contador contador, int incrementos) {
        this.contador = contador;
        this.incrementos = incrementos;
    }
    
    
    
    @Override
    public void run(){
        for (int i = 0; i < incrementos; i++) {
            contador.incrementar();
        }
        System.out.println(Thread.currentThread().getName()+" "+contador.getContador());
        System.out.println(Thread.currentThread().getName()+ " ha terminado");
    }
}
