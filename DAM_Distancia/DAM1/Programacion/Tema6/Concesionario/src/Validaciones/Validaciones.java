/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Validaciones;

/**
 *
 * @author Daniel Martinez
 * 
 * Esta clase es la de validaciones, se validan mediante expresiones regulares:
 *      -matricula
 *      -nombre
 *      -DNI
 *      -fecha
 */
public class Validaciones {
    //metodo para validar la matricula, devuelve true si la matricula es correcta
    public static boolean validarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    //metodo para validar nombre (si empieza por mayuscula y con un apellido)
    public static boolean validarNombre(String nombre){
        return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango] +(minimo se repite 1 vez) [ ] espacio ? optativo y que se repita entre 1 y 2 veces }
    }
    //metodo para validar el DNI, 8 caracteres y terminado en letra mayuscula
    public static boolean validarDNI(String DNI){
        return DNI.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango]$ con el que termina
    }
    /*metodo para validar la fecha:
        (0?[1-9]|[12][0-9]|3[01]):
            -Puede empezar por 0, por 1 o 2, o por 3
            -el rango de 0,1 y 2 es de 0 al 9 (asi tenemos los dias de 01 a 29
            -el rango del 3 es 0 o 1 (30 o 31), con esto tenemos todos los dias
        (0?[1-9]|1[012]):
            -como antes, puede empezar por 0 o por 1
            -el rango del o va del 1 al 9
            -el rango de 1 va del 0 1 o 2 (meses 10, 11 o 12
        ([012][0-9])\\d{2}$:
            -([012][09]) establece el rango de 00 a 29
            -\\d{2} indica que se repite por lo menos 2 veces, la d es rango 0-9
            con esto tenemos desde 0000 a 2999, validando los años
    */
    public static boolean validarFecha(String fechaMatriculacion){
        return fechaMatriculacion.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]([012][0-9])\\d{2}$");
    }
}

