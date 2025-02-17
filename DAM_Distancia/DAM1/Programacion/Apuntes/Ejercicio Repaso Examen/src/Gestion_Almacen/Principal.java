/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Almacen;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Inventario inventario = new Inventario();
    for (int i = 0; i<50; i++){
      inventario.agregarProducto(new Productos ("00"+String.valueOf(i),"Portatil",3,500.00));
    }
    
    inventario.verProdctos();
    
    inventario.actualizarProducto("001", 1.0);
    
    inventario.verProdctos();
    
    inventario.eliminarProducto("001");
    
    inventario.verProdctos();
  }
  
}
