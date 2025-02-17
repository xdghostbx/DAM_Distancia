/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG05_Ejerc1_util;

import java.time.LocalDate;


/*
    Validaciones necesarias:
        -DNI, verificar que tenga 9 caracteres
        -Num kilometros, comprobar que sea mayor que 0
        -Fecha matriculacion, que sea anterior a la fecha actual
        
    Se podría validar que la marca introducida es correcta añadiendo
    un enum que contenga las marcas y luego validar que la introducida por
    el usuario es correcta, pero son muchas marcas y el ejercicio no lo pide

    Algo similar se podría hacer con la matricula, pero como hay varias correctas
    no es tan sencillo hacerlo como con el DNI, a si que me limito a hacerlo
    con DNI, Kilometros y fecha de matriculacion
*/

public class Validaciones {
    //metodo para validar que los numeros introducidos por el usuario son correctos
    public static boolean validarDNI(int dniPropietario){
    return dniPropietario > 9999999 && dniPropietario <= 99999999;
}
    //metodo para comprobar que los kilometros son >0
    public static boolean validarKilometros(int numKilometros){
        return numKilometros > 0;
    }
    
    //metodo para compribar que le fecha de matriculacion es anterior a la fecha actual
    public static boolean validarFecha(LocalDate fechaMatriculacion){
        LocalDate fechaActual = LocalDate.now();
        return fechaMatriculacion.isBefore(fechaActual);
    }
    
    //metodo que devuelve la letra del dni segun los numeros
    public static String algoritmoDNI(int dniPropietario){
        if (validarDNI(dniPropietario)) {
            final String dniLetras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int indiceLetra = dniPropietario % 23;
            char letra = dniLetras.charAt(indiceLetra);
            return String.valueOf(dniPropietario) + letra;
        } else {
            return "DNI no válido";
        }
    }
}

