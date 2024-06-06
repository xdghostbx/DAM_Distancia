
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Escribe un programa en Java que utilice la clase ArrayList para almacenar una lista de colores. 
 * El programa debe seguir los siguientes pasos:

    Crear un ArrayList llamado a.
    Añadir los siguientes colores a a: "rojo", "verde", "azul", "blanco" y "amarillo".
    Imprimir el contenido de la lista.

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
    
    for(int i = 0;i < a.size();i++){
      System.out.println(a.get(i));
    }
  }
  
}
