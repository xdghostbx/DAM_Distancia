/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Almacen;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Inventario {
  ArrayList<Productos> productos;

  public Inventario() {
    this.productos = new ArrayList<>();
  }
  
  public void agregarProducto(Productos producto){
    productos.add(producto);
  }
  
  public void eliminarProducto(String codigo){
    boolean encontrado = false;
    for (Productos producto : productos){
      if (producto.getCodigo().equals(codigo)){
        System.out.println("prodcto encontrado, eliminando el producto...");
        encontrado = true;
        productos.remove(producto);
        break;
      }
    }
    
    if (!encontrado){
      System.out.println("Producto no encontrado");
    }
  }
  
  public void actualizarProducto(String codigo, Double precio){
    boolean encontrado = false;
    for (Productos producto : productos){
      if (producto.getCodigo().equals(codigo)){
        System.out.println("Actualizando el precio del producto");
        producto.setPrecio(precio);
        break;
      }
    }
    
    if (!encontrado){
      System.out.println("Producto no encontrado");
    }
  }
  
  public void verProdctos(){
    for (Productos producto : productos){
      System.out.println(producto.toString());
    }
  }

}
