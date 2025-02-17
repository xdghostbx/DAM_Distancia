/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad9.pkg5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/*
Se genera el archivo Numeros.txt que contiene
un numero real por linea. Dicho archivo debe estar guardado
en la carpeta principal del proyecto
*/
/**
 *
 * @author usuario
 */
public class Actividad95 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("Numeros.txt"));
            Scanner s;
            double suma = 0;
            String linea;
            while ((linea = in.readLine()) != null) { // Lee hasta el final del archivo
                s = new Scanner(linea).useLocale(Locale.US);
                while (s.hasNextDouble()) { // Procesa todos los números en la línea
                    suma += s.nextDouble();
                }
            }
            System.out.println("Suma: " + suma);
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
