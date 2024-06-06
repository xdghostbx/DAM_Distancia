
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Escribe un programa en Java que utilice la clase ArrayList para manejar una lista de colores. 
 * El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado a e inicializarlo con los siguientes colores: "rojo", "verde", 
    "azul", "blanco" y "amarillo".
    Imprimir el contenido de la lista.
    Insertar el color "turquesa" en la posición 1 de la lista.
    Imprimir el contenido de la lista después de insertar "turquesa" en la posición 1.

EJERCICIO 5
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<String> colores = new ArrayList<>();
    colores.add("rojo");
    colores.add("verde");
    colores.add("azul");
    colores.add("blanco");
    colores.add("amarillo");
    
    for (int i = 0; i<colores.size();i++){
      System.out.print(colores.get(i)+" - ");
    }
    System.out.println();
    
    colores.add(1, "turquesa");
    for (int i = 0; i<colores.size();i++){
      System.out.print(colores.get(i)+" - ");
    }
    System.out.println();
  }
  
}
