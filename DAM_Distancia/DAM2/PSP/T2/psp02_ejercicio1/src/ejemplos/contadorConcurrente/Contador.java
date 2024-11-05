/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplos.contadorConcurrente;

/**
 *
 * @author USER
 */
public class Contador {
    int contador = 0;

    public Contador() {
        this.contador = contador;
    }

    public synchronized int getContador() {
        return contador;
    }

    public synchronized int incrementar(){
        contador++;
        return contador;
    }
    
    
}
