/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer09;

import java.util.Scanner;

public class PROG02_Iniciales_Ejer09 {

    public static void main(String[] args) {
        boolean bucle = false;
        Scanner entrada = new Scanner(System.in);
        
        while (!bucle){
            System.out.println("Introduce un año para saber si es o no bisiesto: ");
            int año = entrada.nextInt();
            if ((año % 4 == 0 && año % 100 != 0 ) || (año % 400 == 0)){
                System.out.println("El año "+año+" es bisiesto");
            } else {
                System.out.println("El año "+año+" no es bisiesto");
            }
        }
    }
}
