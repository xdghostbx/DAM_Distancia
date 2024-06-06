
import java.util.HashMap;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * Escribe un programa en Java que utilice la clase HashMap para almacenar una 
 * colección de nombres asociados a números de identificación. 
 * El programa debe realizar las siguientes acciones:

    Crear un HashMap llamado m para almacenar nombres asociados a números de identificación.
    Añadir seis entradas al mapa donde cada número de identificación está asociado a un nombre:
        924: "Amalia Núñez"
        921: "Cindy Nero"
        700: "César Vázquez"
        219: "Víctor Tilla"
        537: "Alan Brito"
        605: "Esteban Quito"
    Imprimir una tabla que muestre los códigos y nombres de las entradas del mapa, con el siguiente formato:

Código Nombre
------ -------------
924 Amalia Núñez
921 Cindy Nero
700 César Vázquez
219 Víctor Tilla
537 Alan Brito
605 Esteban Quito
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    HashMap<Integer,String>m = new HashMap<Integer,String>();
    
    m.put(924, "Amalia Nuñez");
    m.put(921, "Cindy Nero");
    m.put(700, "César Vázquez");
    m.put(219, "Víctor Tilla");
    m.put(537, "Alan Brito");
    m.put(605, "Esteban Quito");
    
    System.out.println("Código  Nombre");
    System.out.println("---------------------");
    for(Integer i:m.keySet()){
      String valores = m.get(i);
      System.out.println(" "+i+"   "+valores);
      
    }
  }
}
