/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 * 
 * Autor Daniel Martínez
 *
 * Ejercicio 1: Implementar un programa que muestre la tabla de multiplicar de 
 * un número leido desde el teclado utilizando al menos tres bucles diferentes.
 * El número leído desde el teclado debe ser menor que 30. En caso contrario
 * se mostrará un mensaje por pantalla y el programa finalizará.
 */
package tabla.prog04_ejerc1;

//importamos la clase scanner para la entrada de datos
import java.util.Scanner;


//Clase para generar las táblas de multiplicar
public class Main {
    //decalro variables estáticas para que puedan ser usadas por todos los métodos
    public static int numero;
    public static int contador = 1;
    
    /* Función principal del programa que pide el número al usuario y verifica 
     * si pertenece al rango indicado en el enunciado antes de mostrar las
     * tablas de multiplicar
     */
    public static void main(String[] args) {
        //iniciamos el objeto escanner
        Scanner entrada = new Scanner (System.in);
        System.out.println("Ingrese un número del 1 al 30: ");
        //solicita el dato al usuario y lo carga en la variable numero
        numero = entrada.nextInt();
        if (1<=numero && numero<=30){
            metodoFor();
            metodoWhile();
            metodoDoWhile();
        }else{
            System.out.println("El número que has ingresado no pertence al rango");
        } 
    }
    
    //metodo para generar la tabla de multiplicar con un bucle For
    public static void metodoFor(){
        System.out.println("Tabla de multiplicar con bucle for: ");
        for (contador = 1; contador <= 10; contador++){
            System.out.println(numero + " x " + contador + " = " + (numero * contador));

        }
    }
    
    //metodo para generar la tabla de multiplicar con un bucle While
    public static void metodoWhile(){
        contador = 1;
        System.out.println("Tabla de multiplicar con bucle while: ");
        while (contador <= 10){
            System.out.println(numero + " x " + contador + " = " + (numero * contador));
            contador++;
        }
    }
    
    //metodo para generar la tabla de multiplicar con un bucle Do-While
    public static void metodoDoWhile(){
        contador = 1;
        System.out.println("Tabla de multiplicar con bucle do-while");
        do{
            System.out.println(numero + " x " + contador + " = " + (numero * contador));
            contador++;
        }while (contador <= 10);
    }
}
