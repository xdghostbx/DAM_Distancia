
import java.util.HashMap;
import java.util.Scanner;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    HashMap<Integer,String> lista = new HashMap<>();
    Scanner entrada = new Scanner (System.in);
    
    lista.put(1111, "Dani");
    lista.put(1222, "Dani");
    lista.put(1333, "Dani");
    lista.put(1444, "Dani");
    lista.put(1555, "Dani");
    lista.put(1666, "Dani");
    
    boolean acceso = false;
    
    for (int i = 0; i<3; i++){
      System.out.println("Introduce un usuario");
      String usuario = entrada.nextLine();
      System.out.println("Introduce la contraseña");
      int psw = entrada.nextInt();
      entrada.nextLine();
      
      if(lista.containsKey(psw) && lista.get(psw).equals(usuario)){
        System.out.println("Tiene acceso al area restringida");
        acceso = true;
        break;
      }else
          System.out.println("intentelo de nuevo");
    }
    
    if (!acceso){
      System.out.println("no tiene acceso al area restringida");
    }
    
  }
  
}
