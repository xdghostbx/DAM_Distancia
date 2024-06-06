
import java.util.HashMap;
import java.util.Scanner;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Crea un mini-diccionario español-inglés que contenga, al menos, 20 palabras 
 * (con su correspondiente traducción). Utiliza un objeto de la clase HashMap  
 * para almacenar las parejas de palabras. El programa pedirá una palabra en  
 * español y dará la correspondiente traducción en inglés.
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner entrada = new Scanner (System.in);
    HashMap<String, String> diccionario = new HashMap<String, String>();
    
    diccionario.put("perro", "Dog");
    diccionario.put("vaso", "Glass");
    diccionario.put("gato", "Cat");
    diccionario.put("ventana", "Window");
    diccionario.put("ordenador", "Computer");
    diccionario.put("raton", "Mouse");
    diccionario.put("bebida", "Drink");
    
    System.out.println("Introduce una palabra para traducir");
    String opcion = entrada.nextLine();
    if(diccionario.containsKey(opcion.toLowerCase())){
      System.out.println(diccionario.get(opcion));
    }else
        System.out.println("No se ha encontrado la palabra en el diccionario");
  }
  
}
