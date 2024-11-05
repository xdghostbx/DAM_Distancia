/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Palillo {
    private int id;
    private boolean usado;

    public Palillo(int id) {
        this.id = id;
        this.usado = false;
    }
    
    
    
    public synchronized void usar(){
        while(usado){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Palillo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        usado = !false;
    }
    
    public synchronized void soltar(){
        usado = !true;
        notify();
    }
}
