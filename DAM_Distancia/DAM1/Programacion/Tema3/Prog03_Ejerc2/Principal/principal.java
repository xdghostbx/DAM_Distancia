/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package com.prog03.Principal;
import com.prog03.figuras.Rectangulo;

/**
 *
 * @author xdGHOSTbx
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangulo rectangulo1 = new Rectangulo();
            rectangulo1.setAltura(5);
            rectangulo1.setBase(5);
        
        Rectangulo rectangulo2 = new Rectangulo();
            rectangulo2.setAltura(10);
            rectangulo2.setBase (12);
        
        rectangulo1.imprimirDatos1();
        rectangulo2.imprimirDatos2();
    }
    
}
