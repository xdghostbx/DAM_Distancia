/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Objetos;

import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Protectora protectora = new Protectora();
    Scanner entrada = new Scanner(System.in);
    while (true) {
      System.out.println("Introduce uan raza");
      String raza = entrada.nextLine();
      System.out.println("Introduce un nombre");
      String nombre = entrada.nextLine();
      System.out.println("Introduce un sexo");
      String sexo = entrada.nextLine();
    }
    
    
    System.out.println("Introduce uan raza");
    String raza = entrada.nextLine();
    System.out.println("Introduce un nombre");
    String nombre = entrada.nextLine();
    System.out.println("Introduce un sexo");
    String sexo = entrada.nextLine();
    Animales animal = new Animales("Sin especificar","Borrego","M");
    Gato gato1 = new Gato(12, "Negro","naranja","Michi","F");
    
    Animales animal2 = new Animales(raza,nombre,sexo);
    protectora.agregarAnimal(animal2);
    
    protectora.agregarAnimal(animal);
    protectora.agregarAnimal(gato1);
    protectora.mostrarAnimales();
    System.out.println("");
  }
  
}
