/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg2;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author usuario
 */

/*
Una vez abierto el flujo, leemos de él caracter a caracter, 
incluidos los cambios de línea, y los camos concatenando en la cena de caracteres
qque al final contendrá el testo completo del archivo Main.java

Este archivo(Main.java) se crea y se añade a la carpeta principal del proyecto
añadiendo el siguiente mensaje:
"Lectura de texto mediante

File reader en actividad 9.2

y bufferedReader en 9.3"

Comprobad que existe dicho archivo en la carpeta.

*/
public class Actividad92 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String texto= "";
        FileReader in = null; //Declaramos fuera de la estructura try-catch para que sea accesible también desde fuera
        
        try{
            in=new FileReader("Main.java");
            int c= in.read();
            while (c != -1){ //mientras no lleguemos al final del archivo
                texto = texto + (char) c;// convertimos c a char
                c = in.read();
            }
        }catch (IOException ex) {
            System.out.println(ex.getMessage()); 
        }finally { //en todo caso cerramos el flujo
            if ( in!= null){ //si el flujo está abierto 
                try{
                    in.close();
                    
                }catch (IOException ex){
                    System.out.println(ex);
                }
            }
        }
        System.out.println(texto);//mostramos el texto leído
    }
    
}
