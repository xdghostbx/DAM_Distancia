/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.contadorConcurrente;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Contador contador = new Contador();
        int numeroHilos = 5;
        Thread[] hilos = new Thread[numeroHilos];
        
        
        for (int i = 0; i < numeroHilos; i++){
            hilos[i] = new Thread( new Incrementador(contador, 50), "hilo "+i);
            hilos[i].start();
        }
        /*
            A cada incremento de i se crea 
        */
        
        // Esperar a que todos los hilos terminen
        for (int i = 0; i < numeroHilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println("Cuenta total: "+contador.getContador());
    }
/**
    //creamos hilos
    Thread hilo1 = new Thread(new Incrementador(contador, 50), "Hilo 1");
    Thread hilo2 = new Thread(new Incrementador(contador, 50), "Hilo 2");
    Thread hilo3 = new Thread(new Incrementador(contador, 50), "Hilo 3");
    Thread hilo4 = new Thread(new Incrementador(contador, 50), "Hilo 4");
    Thread hilo5 = new Thread(new Incrementador(contador, 50), "Hilo 5");


    //creamos hilos con expresion lambda
    Thread hilo1Lambda = new Thread(() -> {
        for (int i = 0; i < 50; i++) {
            contador.incrementar();
        }
    }, "Hilo 1");

    //crear varios hilos con expresiones lambda
    Thread[] hilos = new Thread[5];
    for (int i = 0; i < hilos.length; i++) {
        hilos[i] = new Thread(() -> {
            for (int j = 0; j < 50; j++) {
                contador.incrementar();
            }
        }, "Hilo " + i);
    }
    */
}
