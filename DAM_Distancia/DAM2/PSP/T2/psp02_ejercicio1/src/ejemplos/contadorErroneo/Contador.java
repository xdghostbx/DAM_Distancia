/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.contadorErroneo;

/**
 *
 * @author USER
 */
import java.util.Random;
public class Contador {
    private int contador;
    private Random random;
    public Contador() {
        this.contador=0;
        this.random=new Random();
    }
    public synchronized int getContador() {
        return this.contador;
    }
    public synchronized void incrementa() {
        // contador++;
        int valor=this.contador;
        try { Thread.sleep(random.nextInt(5)); }
        catch (InterruptedException ex) {}
        this.contador=valor+1;
    }
}
