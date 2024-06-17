/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Estanteria;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Estante estanteria = new Estante (5,5);
    
    Bebida bebida1=new Bebida("Agua","Agua Mineral");
    Bebida bebida2 = new Bebida ("Refresco", "Coca-cola");
    
    estanteria.agregarProducto(bebida2, 0, 0);
    estanteria.agregarProducto(bebida1, 0, 4);
    
    estanteria.mostrarEstanteria();
  }
  
}
