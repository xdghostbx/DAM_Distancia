/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package circulo;

import java.util.Scanner;
/**
 *
 * @author xdGHOSTbx
 */
public class PROG03_tutoria_circulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        
        //Creo la variable de circulo con el que se va a hacer el ejercicio
        circulo circuloFinal = new circulo();
        //Pido que se ponga por consola el valor del radio
        circuloFinal.pedirDatos();
        double radio = datos.nextDouble();
        //cargo en circuloFinal el valor del radio
        circuloFinal.setRadio(radio);
        circuloFinal.imprimirDatos();
        
        System.out.print("Ingrese la proporción para aumentar el radio: ");
        double prop = datos.nextDouble();
        circuloFinal.proporcion(prop);
        circuloFinal.imprimirDatos2();
    }
    
}
