/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeroFilosofos = 5;
        Palillo [] palillos = new Palillo [numeroFilosofos];
        Filosofo[] filosofos = new Filosofo [numeroFilosofos];
        
        for (int i = 0; i < numeroFilosofos; i++){
            palillos[i] = new Palillo(i);
        }
        
        for (int i = 0; i< numeroFilosofos; i++){
            filosofos[i] = new Filosofo (i, palillos);
            new Thread (filosofos[i]).start();
        }
    }
    
}
