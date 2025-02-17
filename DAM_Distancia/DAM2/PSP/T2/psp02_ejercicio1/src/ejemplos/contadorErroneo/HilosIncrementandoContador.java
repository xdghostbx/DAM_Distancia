/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.contadorErroneo;

import java.util.Random;

/**
 *
 * @author USER
 */
public class HilosIncrementandoContador {

    public static void main(String[] args) {
    final int NUM_HILOS=10;
    Hilo[] hilos=new Hilo[NUM_HILOS];
    Random random=new Random();
    Contador contador = new Contador();
    for(int i=0;i<NUM_HILOS;i++) {
        hilos[i]=new Hilo("Hilo "+(i+1), contador);
        int prioridad=random.nextInt(Thread.MAX_PRIORITY-1)+1;
        hilos[i].setPriority(prioridad);
        hilos[i].start();
    }
    for(int i=0;i<NUM_HILOS;i++)
        try { hilos[i].join(); }
    catch (InterruptedException ex) {}
System.out.println("Valor del contador: "+contador.getContador());
}
    
}
