/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaConsumidores.ejemplo1;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Buffer {
    private ArrayList<Integer> lista = new ArrayList<Integer>();
    private final int Max = 10;
    private Random random = new Random();
    
    public boolean hayDatos(){
        return lista.size()>0;
    }
    
    public boolean cabenMasDatos(){
        return lista.size()<Max;
    }
    
    public synchronized int get() throws InterruptedException{
        while(!hayDatos())
            wait();
        int dato = lista.remove(0);
        System.out.println("GET "+dato+" ");
        System.out.println(lista);
        notify();
        return dato;
    }
    
    public synchronized void put() throws InterruptedException{
        while (!cabenMasDatos())
            wait();
        int nuevoDato = random.nextInt(100);
        lista.add(nuevoDato);
        System.out.println("PUT "+ nuevoDato+ " ");
        System.out.println(lista);
        notify();
    }
}

enum VelocidadAcceso {
    LENTO(1000), RAPIDO(100), INMEDIATO(0), ALEATORIO(-1);
    private int milisegundos;
    
    VelocidadAcceso(int milisegundos){
        this.milisegundos = milisegundos;
    }
    
    public int getMilisegundos(){
        if(milisegundos>=0){
            return milisegundos;
        }else
            return new Random().nextInt(LENTO.getMilisegundos());
    }
}
