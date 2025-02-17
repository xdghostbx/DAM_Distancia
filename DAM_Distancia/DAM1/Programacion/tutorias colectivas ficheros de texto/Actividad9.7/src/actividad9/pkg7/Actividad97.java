/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
En este ejercicio vamos a escribir un texto, 
por lo tanto no es necesario crear el archivo ni introducir
informacón. Cuando ejecutemos el programa debemos revisar el
archivo "quijote.txt" generado en la carpeta principal
del proyecto actual.


*/
/**
 *
 * @author usuario
 */
public class Actividad97 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new FileWriter("quijote.txt"));
            String cad = "En un lugar de la mancha,"; //primera linea
            for ( int i = 0; i< cad.length(); i++) {
                out.write(cad.charAt(i));
                
            }
            cad = "de cuyo nombre no quiero acordarme."; //segunda linea
            out.newLine();
            out.write(cad);//escribimos con una única sentencia
            
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            if (out != null) {
                try {
                    out.close(); //hacemos que se vacía el búfer y se escriba en el archivo
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el archivo.");
                    ex.printStackTrace();
                }
            
            
           
            }
    }
    
}
}
