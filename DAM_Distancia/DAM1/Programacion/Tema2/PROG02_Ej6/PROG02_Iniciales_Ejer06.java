/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

package dani.martinez.prog02_iniciales_ejer06;

import java.util.Scanner;

enum Razas{
        Mastin, Terrier, Bulldog, Pekines, Caniche, Galgo
}

public class PROG02_Iniciales_Ejer06 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Dada la siguiente lista:\n Mastin, Terrier, Bulldog,"
                + " Pekines, Caniche y Galgo");
        System.out.print("\ningrese el nombre de una raza de perro: ");
        String raza1 = entrada.nextLine();
        System.out.print("\ningrese el nombre de otra raza de perro: ");
        String raza2 = entrada.nextLine();
        
        raza1 = raza1.toLowerCase();
        raza2 = raza2.toLowerCase();

        razas var1 = razas.valueOf(raza1);
        razas var2 = razas.valueOf(raza2); 
        
        int posicionVar1 = var1.ordinal();
        int posicionVar2 = var2.ordinal();
        System.out.println("Posición de "+ raza1 + " en el enumerado: " + posicionVar1);
        System.out.println("Posición de "+ raza2 + " en el enumerado: " + posicionVar2);

        int cantidadValores = razas.values().length;
        System.out.println("Cantidad de valores en el enumerado: " + cantidadValores);
    }
}
