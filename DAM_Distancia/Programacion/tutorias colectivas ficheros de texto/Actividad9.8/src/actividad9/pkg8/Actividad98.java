/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Se genera un archivo en la carpeta main, en mi caso de nombre actividad98.txt, 
cuyo nombre debemos introducir por teclado cuando ejecutemos el programa.Al ejecutarlo crea un archivo llamado
copia_de_actividad98.txt
*/

/**
 *
 * @author usuario
 */
public class Actividad98 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Nombre del fichero: ");
        String fichOriginal = new Scanner(System.in).nextLine();
        String fichCopia = "copia_de_" + fichOriginal;
        /*Abrimos los ficheros para lectura y escritura
         en la misma sentencia del bloque try-catch
        
        */
        try (BufferedReader in =new BufferedReader ( new FileReader (fichOriginal));
            BufferedWriter out = new BufferedWriter(new FileWriter(fichCopia))){
            int c = in.read();
            while (c!=-1) {//mientras no lleguemos al final del fichero copia
               out.write(c);
               c= in.read();
               
            }
            
        }catch (IOException ex){
            ex.getMessage();
        }
    }
    
}
