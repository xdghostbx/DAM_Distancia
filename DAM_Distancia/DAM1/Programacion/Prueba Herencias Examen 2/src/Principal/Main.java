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
    Tenemos un array multidimensional con mesas y numero de ocupantes
    El ejercicio pide que sea de 2 dimensiones 2 filas 10 columnas
    voy a hacer de 3 filas con "ocupado" y "libre"
    */
    Random aleatorio = new Random();
    Scanner entrada = new Scanner(System.in);
    
    String[][] mesas = new String [3][11];
    
    //aplicamos el "titulo" de la posicion 0
    mesas[0][0] = "Mesa numero";
    mesas[1][0] = "Sillas";
    mesas[2][0] = "Estado";
    //ponemos los numeros de las mesas del 1 al 10
    //aplicamos un generador random para poner el numero de comensales
    //ponemos todas las mesas con estado libre
    for (int i = 1;i< 11; i++){
      mesas[0][i]=String.valueOf(i);
      mesas[1][i] = String.valueOf(aleatorio.nextInt(4)+1);
      mesas[2][i] = "Libre";
    }
    
    //imprimimos la tabla
      for (int j = 0;j< 3; j++){
        for (int z = 0;z < 11; z++){
          System.out.print(mesas[j][z]+" ");
        }
        System.out.println();
      }
      
      //menu para seleccionar la mesa segun los comensaleso
      while (true){
        System.out.println("Introduzca el numero de comensales:");
        int comensales = entrada.nextInt();
        entrada.nextLine();
        if (comensales > 4){
          System.out.println("El numero de comensales no puede ser superior a 4");
        }else{
          System.out.println("Introduzca una mesa para sentarse 1 al 10");
          int numMesa = entrada.nextInt();
          entrada.nextLine();
          // Verificar si la mesa tiene suficientes sillas y está libre
          int sillas = Integer.parseInt(mesas[1][numMesa]);
          String estadoMesa = mesas[2][numMesa];

          if (comensales <= sillas && estadoMesa.equals("Libre")) {
              mesas[2][numMesa] = "Ocupada";
              System.out.println("Mesa " + numMesa + " reservada para " + comensales + " comensales.");
          } else if (!estadoMesa.equals("Libre")) {
              System.out.println("La mesa " + numMesa + " ya está ocupada.");
          } else {
              System.out.println("La mesa " + numMesa + " no tiene suficientes sillas.");
          }
        }
        //volvemos a imprimir la tabla para mantener la info actualizada
        for (int j = 0;j< 3; j++){
          for (int z = 0;z < 11; z++){
            System.out.print(mesas[j][z]+" ");
          }
          System.out.println();
        }
      }
      
      
      
  }
  /*
   * Creamos un método para el menú 
   */
  public static void menu(){
    System.out.println("Introduce un nombre para el gato");
  }
}
