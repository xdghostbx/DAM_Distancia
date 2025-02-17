/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
Creamos con un editor de texto Enteros.txt en la carpeta 
rpincipal del proyecto actual de Netbeans y escribir en él una serie de
enteros separados por secuencias de espacios y tabuladores, incluso en distintas lineas:
2   3  45       73
123         4  21
Primero creamos el flujo de texto a partir del nombre del archivo. Como dentro
del bloque try solo se va a abri el archivo y no se va a leer de él,
basta con la exceción FileNotFoundException, que es una subclase de IOException

*/

/**
 *
 * @author usuario
 */
public class Actividad96 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FileInputStream flujo = null;
        try{
            flujo = new FileInputStream("Enteros.txt");
            
        }catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
            
        }
        Scanner s = new Scanner(flujo);
        int contador = 0;
        int suma =0;
        while (s.hasNext()){ //en principio no sabemos cuantos numeros hay
            int n =s.nextInt();
            System.out.println(n + " ");//vamos mostrando los últimos números leídos
            suma += n;
            contador++;
        }
        double media = (double) suma / contador; //la media es un numero real
        System.out.println("\suma: " + suma + "  madia: " + media);
    }
    
}
