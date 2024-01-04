/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Validaciones;

/**
 *
 * @author Dani
 */
public class Validaciones {
    public static boolean validarMatricula(String matricula){
        return matricula.matches("^[0-9]{4}[A-Z]{3}$");
    }
    
    public static boolean validarNombre(String nombre){
        return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango] +(minimo se repite 1 vez) [ ] espacio ? optativo y que se repita entre 1 y 2 veces }
    }
    
    public static boolean validarDNI(String DNI){
        return DNI.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$"); //obliga que empieza y que acabe de esa forma
        // ^empieza [rango] {repeticiones} [rango]$ con el que termina
    }
    
    public static boolean validarFecha(String fechaMatriculacion){
        return fechaMatriculacion.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]([012][0-9])\\d{2}$");
    }
}

