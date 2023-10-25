/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer07;

import java.util.Scanner;
import java.text.DecimalFormat;


public class PROG02_Iniciales_Ejer07 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.####");
        double C1 = 0;
        double C2 = 0;
        boolean valido1 = false;
        boolean valido2 = false;
        
        while (!valido1){
            System.out.print("Ingrese un número para la primera variable: ");
            
            if (entrada.hasNextDouble()){
                C1 = entrada.nextDouble();
                valido1 = true;
            } else {
                System.out.print ("Debe ingresar solamente números. Vuelva a"
                        + " intentarlo\n");
                entrada.nextLine();
            }
        }
        while (!valido2){
            System.out.print("Ingrese un número para la segunda variable: ");
            
            if (entrada.hasNextDouble()){
                C2 = entrada.nextDouble();
                valido2 = true;
            } else {
                System.out.print ("Debe ingresar solamente números. Vuelva a"
                        + " intentarlo\n");
               entrada.nextLine();
            }
        }
        
        double x = (-C2)/C1;
        System.out.print(C1+"X + "+C2+", despejando X es: "
                + "\nx = -("+C2+")/"+C1 +", que es igual a: "
                + formato.format(x) );
    }
}
