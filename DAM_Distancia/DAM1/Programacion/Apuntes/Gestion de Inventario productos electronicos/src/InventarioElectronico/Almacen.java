/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package InventarioElectronico;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Almacen {
  ArrayList<Producto> productos;

  public Almacen() {
    this.productos = new ArrayList<>();
  }
  
  public void agregarProducto(Producto producto){
     productos.add(producto);
  }
  
  public void verListaProductos(){
    for (Producto producto : productos){
      System.out.println(producto.toString());
    }
  }
  
  public Producto buscarInfoCodigo(int codigo){
    for (Producto producto : productos){
      if(producto.getCodigo()==codigo){
        System.out.println("Producto encontrado");
        return producto;
      }
    }
    return null;
  }
  
  public void venderProducto (int codigo){
    boolean encontrado = false;
    int stock;
    for (Producto producto : productos){
      if(producto.getCodigo()==codigo && producto.getStock()> 0){
        encontrado = true;
        System.out.println("Se ha encontrado tu producto, procediendo a la venta");
        stock = producto.getStock();
        stock --;
        producto.setStock(stock);
        if(producto.getStock()==0){
          producto.setEstado(false);
        }
        System.out.println("Se ha vendido el producto por "+producto.getPrecio()+" €\n");
      }
      if(producto.getCodigo()==codigo && producto.getStock()== 0){
        encontrado = true;
        System.out.println("No queda stock del producto");
        break;
      }
    }
    
    if(!encontrado)
        System.out.println("No se ha encontrado el producto");
  }
  
  public void consultarStock (int codigo){
    boolean encontrado = false;
    int stock;
    for (Producto producto : productos){
      if(producto.getCodigo() == codigo && producto.getStock()> 0){
        encontrado = true;
        System.out.println("Se ha encontrado tu producto, tiene un stock de "+producto.getStock()+" unidades");
      }
      if(producto.getCodigo()==codigo && producto.getStock()== 0){
        encontrado = true;
        System.out.println("No queda stock del producto");
        break;
      }
    }
    
    if(!encontrado)
        System.out.println("No se ha encontrado el producto");
  }
  
  public void actualizarInformacion(int codigo){
    boolean encotrado;
  }
}
