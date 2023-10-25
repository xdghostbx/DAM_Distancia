/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer04;

import java.util.Scanner;


public class PROG02_Iniciales_Ejer04 {
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        int edad;
        while (true){
        
            System.out.println("Ingrese su edad: ");
            edad= entrada.nextInt();
            
            while (edad < 18){
            
                System.out.println("Usted es menor de edad");
                System.out.println("Ingrese su edad: ");
                edad= entrada.nextInt();
            }
            
            System.out.println("Usted es mayor de edad");

            /*
             * Otra opción de trabajo es el uso del operador ternario de comparación, como en este 
             * caso no podemos usar IF, quedaría tal que así:
             *   
             * Scanner entrada = new Scanner (System.in);
             * int edad;
             * System.out.println((edad >= 18 ? "Es mayor de edad" : "No es mayor de edad"));
             *
             */
        }
    }
}
