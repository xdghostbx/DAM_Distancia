/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*
se crea el archivo NumerosReales.txt que continene una fila de números
separados poro un espacio simple entre ellos. Se guarda en la carpeta principal
de este mismo proyecto. 
*/
/**
 *
 * @author usuario
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Actividad94 {

    public static void main(String[] args) {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("NumerosReales.txt"));
            String texto = in.readLine();
            if (texto != null) {
                String[] subcadenas = texto.split(" ");
                double suma = 0;
                for (int i = 0; i < subcadenas.length; i++) {
                    suma += Double.valueOf(subcadenas[i]);
                }
                System.out.println("Suma: " + suma + "\tMedia: " + suma / subcadenas.length);
            } else {
                System.out.println("El archivo está vacío.");
            }
        } catch (IOException ex) {
            System.out.println("Error: No se pudo abrir o leer el archivo.");
            ex.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println("Error al cerrar el archivo.");
                    ex.printStackTrace();
                }
            }
        }
    }
}

