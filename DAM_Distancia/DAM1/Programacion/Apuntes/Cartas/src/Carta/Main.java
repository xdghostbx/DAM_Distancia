/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Carta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    HashMap<String,Integer> puntos = new HashMap<>();
    
    puntos.put("as", 11);
    puntos.put("tres",10);
    puntos.put("sota",2);
    puntos.put("caballo",3);
    puntos.put("rey",4);
    
    
    ArrayList<Carta> baraja = new ArrayList<>();
    for (int i = 0; i<5;i++){
      baraja.add(Puntuaciones.generarCarta());
    }
    
    for (int i = 0; i<5;i++){
      System.out.println(baraja.get(i));
    }
    int puntuacion = 0;
    for(Carta carta : baraja){
      if(puntos.containsKey(carta.getValor())){
        puntuacion += puntos.get(carta.getValor());
      }
    }
    System.out.println("Puntuacion = "+puntuacion);
  }
  
}
