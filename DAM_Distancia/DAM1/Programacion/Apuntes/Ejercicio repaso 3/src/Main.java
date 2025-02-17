
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Escribe un programa en Java que utilice la clase ArrayList para manejar una lista de colores. 
 * El programa debe realizar las siguientes acciones:

    Crear un ArrayList llamado a e inicializarlo con los siguientes colores: "rojo", "verde", "azul", 
    "blanco", "amarillo" y "blanco" (permitiendo duplicados).
    Imprimir el contenido de la lista.
    Verificar si la lista contiene el color "blanco" e imprimir un mensaje correspondiente.
    Eliminar la primera ocurrencia del color "blanco" de la lista.
    Imprimir el contenido de la lista después de eliminar la primera ocurrencia de "blanco".
    Eliminar el elemento en la posición 2 de la lista.
    Imprimir el contenido de la lista después de eliminar el elemento en la posición 2.

 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<String> a = new ArrayList<>();
    a.add("rojo");
    a.add("verde");
    a.add("azul");
    a.add("blanco");
    a.add("amarillo");
    a.add("blanco");
    
    for (int i = 0; i<a.size();i++){
      System.out.print(a.get(i)+" - ");
    }
    for (int i = 0; i<a.size();i++){
      if (a.get(i).equals("blanco")){
        System.out.println("La lista tiene el color blanco");
        break;
      }
    }
    for (int i = 0; i<a.size();i++){
      if (a.get(i).equals("blanco")){
        a.remove(i);
        break;
      }
    }
    for (int i = 0; i<a.size();i++){
      System.out.print(a.get(i)+" - ");
    }
    a.remove(1);
    for (int i = 0; i<a.size();i++){
      System.out.print(a.get(i)+" - ");
    }
  }
  
}
