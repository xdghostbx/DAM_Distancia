/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer05;

import java.util.Scanner;
import java.text.DecimalFormat;


public class PROG02_Iniciales_Ejer05 {

    public static void main(String[] args) {
        DecimalFormat formato = new DecimalFormat("##.###");
        double segundos = 0;
        while (segundos > -1){
            Scanner entrada = new Scanner (System.in);
            System.out.println("Ingrese un número de segundos: ");
            segundos = entrada.nextDouble();
            double minutos = segundos/60;
            double horas = minutos/60;
            double dias = horas/24;
            System.out.println("Dada la cantidad de: " + segundos + 
                    " segundos, tendríamos: \n ->" + formato.format(minutos) +
                    " minutos\n ->" +formato.format(horas)+" horas\n ->" + 
                    formato.format(dias)+" dias");
        }   
    }
}
