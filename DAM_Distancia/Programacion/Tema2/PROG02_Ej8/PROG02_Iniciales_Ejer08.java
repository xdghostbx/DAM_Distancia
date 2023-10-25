/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer08;

import java.util.Scanner;
import java.text.DecimalFormat;

public class PROG02_Iniciales_Ejer08 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat formato = new DecimalFormat("#.#");
        boolean valido = false;

        int programacion = 0;
        int entornos = 0;
        int bases = 0;

        while (!valido) {
            System.out.println("Introduce el número de matriculados en Programación: ");
            
            if (entrada.hasNextInt()) {
                programacion = entrada.nextInt();
                System.out.println("Introduce el número de matriculados en Entornos de Desarrollo: ");
                
                if (entrada.hasNextInt()) {
                    entornos = entrada.nextInt();
                    System.out.println("Introduce el número de matriculados en Bases de datos: ");
                    
                    if (entrada.hasNextInt()) {
                        bases = entrada.nextInt();
                        valido = true;
                    } 
                }
            }
            if (!valido){
                System.out.println("Solo se pueden introducir números en este campo\n vuelve a intentarlo");
                entrada.nextLine();
            }
        }

        int totalAlumnos = programacion + bases + entornos;
        double porcProgramacion = (programacion * 100.0) / totalAlumnos;
        double porcEntornos = (entornos * 100.0) / totalAlumnos;
        double porcBases = (bases * 100.0) / totalAlumnos;

        System.out.println("El % de matriculados en programación"
                + " es de: " + formato.format(porcProgramacion) + "%");
        System.out.println("El % de matriculados en Entornos de Desarrollo"
                + " es de: " + formato.format(porcEntornos) + "%");
        System.out.println("El % de matriculados en Bases de Datos"
                + " es de: " + formato.format(porcBases) + "%");
    }
}
