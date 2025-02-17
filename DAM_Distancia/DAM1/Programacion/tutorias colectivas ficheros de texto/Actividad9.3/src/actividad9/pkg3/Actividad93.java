/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg3;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Actividad93 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto= "";
        BufferedReader in = null; //Declaramos fuera de la estructura try-catch para que sea accesible también desde fuera
        
        try{
            in=new BufferedReader(new FileReader("Main.java"));
            String linea= in.readLine();
            while (linea != null){ //mientras no lleguemos al final del archivo
                texto = texto + linea + '\n';// el cambio de linea hay que insertarlo manualmente
                linea = in.readLine();
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage()); 
        }finally {
            if ( in!= null){
                try{
                    in.close();
                    
                }catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }
        System.out.println(texto);
    }
 }
    

