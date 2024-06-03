/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

import Animales.*; //importamos todo el paquete de animales
import java.util.Random;
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
    /*
    Realiza un programa que pida 8 números enteros y que luego muestre esos
    números junto con la palabra “par” o “impar” según proceda.
    */
    Scanner entrada = new Scanner(System.in);
    Random aleatorio = new Random();

    int[] numero = new int[8];

    for (int i = 0; i< numero.length;i++){
      numero[i] = aleatorio.nextInt(50);
    }
    
    for(int i = 0; i< numero.length;i++){
      if(numero[i]%2==0){
        System.out.println(numero[i]+" es par");
      }else
          System.out.println(numero[i]+" es impar");
    } 
  }
  /*
   * Creamos un método para el menú 
   */
  public static void menu(){
    System.out.println("Introduce un nombre para el gato");
  }
}
