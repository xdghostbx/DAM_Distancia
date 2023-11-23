/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 * 
 * Autor Daniel Martínez
 *
 * Ejercicio 5: Implementa un programa Java que calcule la división de 2 numeros
 * solicitados por teclado (dividendo y divisor). El programa solicitará numeros
 * indefinidamente hasta que los 2 numeros solicitados sean -1.
 * Se debe controlar mediante excepciones que el divisor no sea 0. En caso de
 * serlo, se mostrará un mensaje por pantalla. tambien habrá que mostrar por
 * pantalla el número de divisiones calculadas. Utiliza numeros enteros para
 * las variables.
 */

package division.prog04_ejerc5;

//importamos la clase scanner para la entrada de datos
import java.util.Scanner;

public class PROG04_Ejerc5 {
    //decalro variables estáticas para que puedan ser usadas por todos los métodos
    public static int dividendo;
    public static int divisor;
    public static int divTotal=0;
    public static int resultado;
    
    /* Uso un bucle while donde permanece en el hasta que ambas variables 
     * son -1
     * Luego, con el try, el programa se ejecuta normal, pero si hay un error
     * de tipo aritmetico (reflejado en el catch), da el mensaje de error
     * Tiene un sumatorio de +1 para cada ciclo dentro del bucle
    */
    public static void main(String[] args) {
        Scanner entrada = new Scanner (System.in);
        while (dividendo != -1 && divisor != -1){
            try{
                System.out.println("Ingrese 2 números para empezar a dividir"
                        + "\nSi introduces ambos como -1, el programa se cerrará."
                        + "\nIntroduce el dividendo: ");
                dividendo = entrada.nextInt();
                System.out.println("Introduce el divisor: ");
                divisor = entrada.nextInt();
                resultado = dividendo / divisor;
                System.out.println(dividendo+"/"+divisor+"="+resultado);
                
            }catch (ArithmeticException ex){
                System.out.println("Error: no se puede dividir entre 0");
            }
            divTotal++;
        }
        System.out.println("En numero total de divisiones ha sido de "+divTotal);
        
    }
}
