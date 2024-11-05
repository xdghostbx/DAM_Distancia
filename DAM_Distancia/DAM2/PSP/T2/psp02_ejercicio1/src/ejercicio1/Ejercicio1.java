/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author Daniel Martínez
 * 
 * 
 */

/*
    Enunciado.

    Ejercicio 1

    De igual manera a lo visto en el tema, ahora te proponemos un ejercicio del tipo
    productor-consumidor que mediante un hilo productor almacene datos (15 caracteres)
    en un búfer compartido, de donde los debe recoger un hilo consumidor (consume 15 caracteres).
    La capacidad del búfer ahora es de 6 caracteres, de manera que el consumidor podrá
    estar cogiendo caracteres del búfer siempre que éste no esté vacío. El productor
    sólo podrá poner caracteres en el búfer, cuando esté vacío o haya espacio.
*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BlockingQueue<Character> cola = new LinkedBlockingQueue<>(6);
        int numProductos = 15;
        Thread productor = new Thread(new Productor(cola,numProductos));
        Thread consumidor = new Thread(new Consumidor(cola, numProductos));
        
        productor.start();
        consumidor.start();
        
        try {
            // Esperar a que el productor y consumidor terminen
            productor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
