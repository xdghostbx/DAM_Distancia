/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Eurocoin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    List<Moneda> moneda = new ArrayList<>();
    for (int i = 0; i<6;i++){
      Moneda moneda1 = Eurocoin.generarMoneda();
      moneda.add(moneda1);
    }
    for (int i = 0; i<6;i++){
      System.out.println(moneda.get(i));
    }
    
  }
  
}
