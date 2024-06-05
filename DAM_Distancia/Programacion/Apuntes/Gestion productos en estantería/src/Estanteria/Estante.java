/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Estanteria;

/**
 *
 * @author xdGHOSTbx
 */
public class Estante {
  private Producto[][] productos;
  
  public Estante(int filas, int columnas){
    this.productos = new Producto[filas][columnas];
  }
  
  public void agregarProducto(Producto producto, int fila, int columna){
    if(fila < productos.length && columna < productos[fila].length){
      if(productos[fila][columna] == null){
        productos[fila][columna]=producto;
        System.out.println("Producto añadido a la estanteria"
                + " en la posicion" + fila + " - "+ columna);
      }else
          System.out.println("no se ha podido agregar a la posicion");
    }
  }
  
  public void mostrarEstanteria(){
    for (int i = 0; i<productos.length;i++){
      for(int j = 0; j<productos[i].length;j++){
        if (productos[i][j]!=null) {
          System.out.print(productos[i][j].toString()+" | ");
        }else
            System.out.print("empty |");
      }
      System.out.println();
    }
  }
}
