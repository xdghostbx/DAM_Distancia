/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemplo_ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author conde
 */
public class Ejemplo_Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Carta aux;
    int puntuacion = 0;
    ArrayList<Carta> baraja = new ArrayList();
    HashMap<String, Integer> puntuaciones = new HashMap();
    
    puntuaciones.put("as", 11);
    puntuaciones.put("3", 10);
    puntuaciones.put("sota", 2);
    puntuaciones.put("caballo", 3);
    puntuaciones.put("rey", 4);
    
    while (baraja.size() != 5) { // Escoge 5 cartas, no repetidas.
      aux = new Carta();
      
      if (!baraja.contains(aux)) {
        baraja.add(aux);
      }
    }
    
    System.out.println("Las cartas escogidas son: ");
    for (Carta c : baraja) {
      System.out.println(c);
    }
    
    for (Carta c : baraja) { // Se recogen los valores
      if (puntuaciones.get(c.getValor()) != null) {
        puntuacion += puntuaciones.get(c.getValor());
      }
    }
    
    System.out.println("Tienes " + puntuacion + " puntos");
    }
    
}
