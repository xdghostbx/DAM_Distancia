/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 * 
 * Autor Daniel Martínez
 *
 * Ejercicio 3: Implementa un programa Java que pida 2 numeros  por teclado 
 * Comprueba que son positivos y calcula su MCM. En caso de no ser ambos numeros
 * positivos, el programa mostrará un mensaje por pantalla y finalizará 
 */

package mcm.prog04_ejerc3;

//importamos la clase scanner para la entrada de datos
import java.util.Scanner;

//clase prinicpal para el cálculo del mcm entre 2 numeros
public class PROG04_Ejerc3 {
    //decalro variables estáticas para que puedan ser usadas por todos los métodos
    public static double numero;
    public static double numero2;
    public static double x;
    public static double y;
    public static double mcm;
    
    //
    public static void main(String[] args) {
        recogerDatos();//llamo al metodo recoger datos
        if (esNegativo()){ //si es True, manda el mensaje por pantalla
            System.out.println("Uno o ambos de los números introducidos"
                    + " son negativos");
        }else { //de ser falso, calcula el mcm
            mcm();
        }
    }
    
    /* Metodo para recoger los datos del usuario
     * Para ello, uso un bucle for que va aumentando el valor de i del 1 al 2
     * y mediante un objeto scanner carga esos datos en su variable
     * Esta carga de datos se hace a traves de la estructura switch-case
     * donde en cada valor de i (casos del 1 al 2) carga los datos en su variable
     * correspondiente (numero, numero2)
    */
    public static void recogerDatos(){
        System.out.println("Programa para dar el MCM de 2 números: ");
        Scanner entrada = new Scanner (System.in);
        for (int i=1; i<=2; i++){
            System.out.println("Introduce el " + i +"º número: ");
            switch (i){
                case 1: 
                    numero = entrada.nextDouble();
                    break;
                case 2: 
                    numero2 = entrada.nextDouble();
                    break;
            }
        }
    }
    
    /* Metodo boolean para identificar si un numero o ambos es negativo
     * de ser negativo, da el return como true y de ser positivo, como false
    */
    public static boolean esNegativo(){
        if (numero<0 || numero2<0){
            return true;
        }else return false;
    }
    
    /* Metodo para el cálculo del MCM
     * Inicializo la variable max cargada con los datos del primer numero
     * Lo comparo con el valor del segundo, si el segundo es mayor, este pasa
     * a ser el valor de max. 
     * Aquí inicializo la variable mcm y la cargo con el valor de max
     * Ahora uno un bucle while que sigue ejecutandose hasta que el valor de
     * mcm dividido entre ambos número tenga resto 0, es decir, que es una
     * division entera. En cada repetición del bucle incremento el valor
     * de mcm en 1
    */
    public static void mcm(){
        double max = numero;
        if (numero2 > max){
            max = numero2;
        }
        
        mcm = max;
        while ((mcm % numero != 0) || (mcm % numero2 !=0))
            mcm++;
        System.out.println("El MCM de " + numero + " y " + numero2 + " es "
            + mcm);
    }
}
