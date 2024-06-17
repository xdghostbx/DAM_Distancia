
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * scribe un programa en Java que utilice la clase ArrayList para manejar una lista de 
 * objetos de tipo Gato. Cada gato tiene un nombre, un color y una raza. El programa debe 
 * realizar las siguientes acciones:

    Crear un ArrayList llamado g para almacenar objetos de tipo Gato.
    Añadir cuatro gatos a la lista con los siguientes datos:
        Nombre: "Garfield", Color: "naranja", Raza: "mestizo"
        Nombre: "Pepe", Color: "gris", Raza: "angora"
        Nombre: "Mauri", Color: "blanco", Raza: "manx"
        Nombre: "Ulises", Color: "marrón", Raza: "persa"
    Imprimir los datos de cada gato en la lista.

 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<Gato> gatos = new ArrayList<>();
    
    gatos.add(new Gato("Garfield","naranja","mestizo"));
    gatos.add(new Gato("Pepe","gris","angora"));
    gatos.add(new Gato("Mauri","blanco","manx"));
    gatos.add(new Gato("Ulises","marron","persa"));
    
    for(Gato gato : gatos){
      System.out.println(gato.toString());
    }
  }
  
}
