/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

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
    String pais[] = {"España","Rusia","Japón","Australia"};
    int [][] estaturas;
    estaturas = new int [4][10];
    Scanner entrada = new Scanner(System.in);
    int minimo=211, maximo=0, media=0;
    for (int i = 0; i< 4; i++){
      for(int j = 0; j<10;j++){
        estaturas[i][j] = (int)((Math.random()*70)+140);
      }
    }
    System.out.println("El array visualizado sería");
    
  }
  public void pintaTabla(String pais[], int estaturas[][], int maximo,int minimo, int media){
    for (int i = 0; i< 4; i++){
      System.out.print(pais[i]+" ");
      for(int j = 0; j<10;j++){
        System.out.print(estaturas[i][j]+" ");
        if(estaturas[i][j]<minimo){
          minimo = estaturas[i][j];
        }
        if(estaturas[i][j]>maximo){
          maximo = estaturas[i][j];
        }
        media += estaturas [i][j];
      }
      System.out.print("|"+minimo+" "+maximo+" "+(media/10));
      System.out.println();
      maximo = 0;minimo = 211; media = 0;
    }
  }
}
