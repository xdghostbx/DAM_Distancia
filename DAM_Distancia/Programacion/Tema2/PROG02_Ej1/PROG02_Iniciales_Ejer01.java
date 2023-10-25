/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer01;

/**
 *
 * Crea un proyecto en Netbeans denominado PROG02_Iniciales_Ejer01 con una clase clase y método main y declara e inicializa una variable para almacenar cada uno de los siguientes valores. Trata de utilizar el tipo de datos de mas se ajuste a los datos. Justifica tu elección.
 *
 *  Valor máximo no modificable: 5000.
 *  Si el nuevo empleado tiene carnet de conducir o no.
 *  Un mes del año en formato numérico y como cadena.
 *  El nombre y apellidos de una persona.
 *  Sexo: con dos valores posibles 'V' o 'M'.
 *  Milisegundos transcurridos desde el 01/01/1970 hasta nuestros días.
 *  Saldo de una cuenta bancaria.
 *  Distancia en kms desde la Tierra a Júpiter.
 *
 *
 */
public class PROG02_Iniciales_Ejer01 {

    public static void main(String[] args) {
        
        
        final int NOMODIF = 5000;
        /*
         * Los final van todo en mayuscula
         * usamos int porque es correcto para numeros enteros y el final porque 
         * es su valor final, no modificable
         */
        
        boolean carnet = true;
        String respuesta = "";
        
        if (carnet == true){
            respuesta = "Si";
        }else{
            respuesta = "No";
        }
        /*
         * Boolean porque solo necesitamos representar Si (true) o no (false)
         * A mayores, para que por consola no salga el true o false como respuesta
         * le agrego el if y el String respuesta para que salga como "Si" o "No"
         */
        
        byte numMes = 10;
        String nombreMes = "Octubre"; //entre " porque es texto
        
        /*
         * Usamos byte al ser solo numeros del 1 a l2
         * Usamos String porque para los meses es mejor usar datos de texto
         */
        
        String nombre = "Daniel";
        String apellidos = "Martinez Martinez";
        
        /*
         * Misma justificación que para el String del caso anterior, al ser
         * datos de tipo texto
         */ 
        
        char sexo = 'V';
        
        /*
         * Usamos char porque se representa con un unico caracter 'V' o 'M'
         * A la hora de comprobar el ejercicio me he dado cuenta que va con 
         * comillas simples. Con comillas van las cadenas
         */
        
        long miliSec = System.currentTimeMillis();
        
        /*
         * Usamos System.currentTimeMillis(), que es un metodo propio de Java
         * que da el tiempo transcurrido desde la fecha que pide el ejercicio
         * que coincide con el "epoch"
         * Usamos long porque es un numero grande, que puede exceder el valor
         * de un int
         */
        
        double saldo = 354.61;
        
        /*
         * Usamos double porque los saldos de las cuentas pueden tener decimales
         */
        
        int distancia = 611000000; 
        
        /*
         * Me parece correcto usar int porque es un numero grande pero "sin 
         * decimales". 
         */
        

        
        System.out.print ("Valor máximo no modificable: " + noModif);
        System.out.print ("\nEl nuevo empleado tiene carnet?: " + respuesta);
        System.out.print("\nEl mes de " + nombreMes + " tiene " + numMes + " dias");
        System.out.print("\nMi nombre es " + nombre + " y mis apellidos son " +
                apellidos);
        System.out.print("\nMi sexo es " + sexo);
        System.out.print("\nEl total de milisegundos desde 1/1/1970 es de: "+ 
                miliSec);
        System.out.print("\nMi saldo de cuenta bancaria es de: " + saldo + "€");
        System.out.print("\nLa distancia entre la tierra y júpiter es de " + 
                distancia + " Km");
    }
}
