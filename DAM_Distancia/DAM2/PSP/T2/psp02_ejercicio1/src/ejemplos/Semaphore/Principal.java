/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplos.Semaphore;

/**
 *
 * @author USER
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parking parking = new Parking(1);
        int cantidadHilos = 10;
        
        for (int i = 0; i < cantidadHilos; i++){
        Thread proceso = new Thread(parking,""+ i);
        proceso.start();
        }
        
    }
    
}
