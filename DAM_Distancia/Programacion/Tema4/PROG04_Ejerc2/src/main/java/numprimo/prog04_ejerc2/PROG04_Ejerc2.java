/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 * 
 * Autor Daniel Martínez
 *
 * Ejercicio 2: Implementa un programa Java que pida por teclado 5 números 
 * Para cada uno de ellos:
 * -> Comprueba si es negativo. De serlo muestra por pantalla "El númeror es negativo"
 * -> Si es positivo, deberá mostrar si es positivo o no
 * -> Procesados los 5 números el programa finalizará
 */

package numprimo.prog04_ejerc2;

//importamos la clase scanner para la entrada de datos
import java.util.Scanner;

// clase para identificar si 5 números dados son positivos/negativos y primos
public class PROG04_Ejerc2 {
    //decalro variables estáticas para que puedan ser usadas por todos los métodos
    public static double numero;
    public static double numero2;
    public static double numero3;
    public static double numero4;
    public static double numero5;
    
    
    public static void main(String[] args) {
        recogerDatos();//llamo al metodo recoger datos
        
        /* Uso un bucle for con la variable a con valores del 1 al 5 para pasar
         * de uno a otro de los numeros introducidos a traves de la estructura
         * switch-case (porque me es comodo al ser solo 5 valores)
         * dentro de cada case llamo al método correspondiente a cada número
         * donde numero = num; numero2 = num2 , etc
         * y con la estructura if doy las distintas respuestas
        */
        for (int a=1; a<=5 ; a++){
            switch (a){
                case 1:
                    if (numero<0){
                        System.out.println("El "+a+"º numero introducido es negativo");
                    }else{
                        if (num1()){
                            System.out.println(numero + " es primo.");
                        } else{
                            System.out.println(numero + " no es primo.");
                        }
                    }
                    break;
                case 2:
                    if (numero2<0){
                        System.out.println("El "+a+"º numero introducido es negativo");
                    }else{
                        if (num1()){
                            System.out.println(numero2 + " es primo.");
                        } else{
                            System.out.println(numero2 + " no es primo.");
                        }
                    }
                    break;
                case 3:
                    if (numero3<0){
                        System.out.println("El "+a+"º numero introducido es negativo");
                    }else{
                        if (num1()){
                            System.out.println(numero3 + " es primo.");
                        } else{
                            System.out.println(numero3 + " no es primo.");
                        }
                    }
                    break;
                case 4:
                    if (numero4<0){
                        System.out.println("El "+a+"º numero introducido es negativo");
                    }else{
                        if (num1()){
                            System.out.println(numero4 + " es primo.");
                        } else{
                            System.out.println(numero4 + " no es primo.");
                        }
                    }
                    break;
                case 5:
                    if (numero5<0){
                        System.out.println("El "+a+"º numero introducido es negativo");
                    }else{
                        if (num1()){
                            System.out.println(numero5 + " es primo.");
                        } else{
                            System.out.println(numero5 + " no es primo.");
                        }
                    }
                    break;
                
            }
        }
        
    }
    
    /* Metodo para recoger los datos del usuario
     * Para ello, uso un bucle for que va aumentando el valor de i del 1 al 5
     * y mediante un objeto scanner carga esos datos en su variable
     * Esta carga de datos se hace a traves de la estructura switch-case
     * donde en cada valor de i (casos del 1 al 5) carga los datos en su variable
     * correspondiente (numero, numero2, etc)
    */
    public static void recogerDatos(){
        System.out.println("Programa para verificar si un número es primo: ");
        Scanner entrada = new Scanner (System.in);
        for (int i=1; i<=5; i++){
            System.out.println("Introduce el " + i +"º número: ");
            switch (i){
                case 1: 
                    numero = entrada.nextDouble();
                    break;
                case 2: 
                    numero2 = entrada.nextDouble();
                    break;
                case 3: 
                    numero3 = entrada.nextDouble();
                    break;
                case 4: 
                    numero4 = entrada.nextDouble();
                    break;
                case 5: 
                    numero5 = entrada.nextDouble();
                    break;
            }
        }
    }
    
    /* Metodos para verificar si el número es o no es primo. Uso boolean
     * porque con la lógica que verifica si es primo, si como return tiene "true"
     * es primo, y en caso contrario es false
     * 
     * Solo comento el primero porque hacen todos lo mismo, solo cambio la
     * variable (num, num2, etc)
    */
    public static boolean num1(){
        if (numero<=1){
            return false;
        }
        for (int a = 2; a <= Math.sqrt(numero); a++){
            if (numero % a == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean num2(){
        if (numero2<=1){
            return false;
        }
        for (int a = 2; a <= Math.sqrt(numero2); a++){
            if (numero2 % a == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean num3(){
        if (numero3<=1){
            return false;
        }
        for (int a = 2; a <= Math.sqrt(numero3); a++){
            if (numero3 % a == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean num4(){
        if (numero4<=1){
            return false;
        }
        for (int a = 2; a <= Math.sqrt(numero4); a++){
            if (numero4 % a == 0){
                return false;
            }
        }
        return true;
    }
    public static boolean num5(){
        if (numero5<=1){
            return false;
        }
        for (int a = 2; a <= Math.sqrt(numero5); a++){
            if (numero5 % a == 0){
                return false;
            }
        }
        return true;
    }
}
