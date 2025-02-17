
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Escribe un programa en Java que utilice la clase ArrayList para almacenar una lista de colores. 
 * El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado colores.
    Añadir los colores "rojo", "verde" y "azul" a colores.
    Añadir el color "blanco" a colores.
    Imprimir el número total de colores en la lista.
    Imprimir el color que está en la primera posición de la lista.
    Intentar imprimir el color que estaría en la posición 3 de la lista. 
    * Asegúrate de manejar apropiadamente el caso en el que la posición esté fuera del rango de la lista.

 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<String> colores;
    
    colores = new ArrayList<>();
    
    colores.add("Rojo");
    colores.add("Verde");
    colores.add("Azul");
    colores.add("Blanco");
    int tam = colores.size();
    System.out.println(tam);
    
    System.out.println(colores.get(0));
    System.out.println(colores.get(2));
  }
  
}
