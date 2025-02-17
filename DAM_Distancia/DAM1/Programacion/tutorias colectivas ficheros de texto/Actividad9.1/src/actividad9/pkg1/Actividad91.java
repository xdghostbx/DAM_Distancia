/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg1;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Actividad91 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       leerEntero();
       
       
    }
 /*
    Establecemos un bucle infinito del que solo nos puede sacar el break que,
    por otra parte, solo se ejecutará si se produce la lectura de Scanner sin que salte una excepción
    InoutMismarchException por una entrada de tipo erróneo
    */   
    static Integer leerEntero() {
        Integer resultado;
        while(true){
            try{
            System.out.println("Introducir entero: ");
            resultado = new Scanner(System.in).nextInt();
            break; //aqui se llega solo si la lectura del Scanner ha sido correcta
            
        }catch (InputMismatchException ex){
                System.out.println("Tipo erróneo");
                }
        
        
        }
        return resultado;
    }
    
}
