/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package InventarioElectronico;

import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Almacen almacen = new Almacen();
    Scanner e = new Scanner(System.in);
    int opcion = 0;
    
    //agrego un par de productos previos al almacen
    almacen.agregarProducto(new Smartphone("Iphone 15","Apple",1,1230.50,5,45));
    almacen.agregarProducto(new Portatil("XJ15P","Lenovo",2,700.00,2,25));
    do{
      menu();
      opcion = e.nextInt();
      e.nextLine();
      
      switch (opcion){
        case 1:
          break;
        case 2:
          almacen.verListaProductos();
          break;
        case 3:
          System.out.println("Introduce el codigo de producto que quieres obtener informacion");
          int codigo = e.nextInt();
          e.nextLine();
          Producto producto = almacen.buscarInfoCodigo(codigo);
          if (producto != null){
            System.out.println(producto.toString());
          }else
              System.out.println("producto no encontrado");
          break;
        case 4:
          System.out.println("Introduce el codigo de producto que quieres vender");
          codigo = e.nextInt();
          e.nextLine();
          almacen.venderProducto(codigo);
          break;
        case 5:
          System.out.println("Introduce el codigo de producto que quieres consultar el stock");
          codigo = e.nextInt();
          e.nextLine();
          almacen.consultarStock(codigo);
          break;
        case 6:
          break;
        case 7:
          System.out.println("saliendo...");
          break;
        default:
          System.out.println("introduce una opcion valida...");
          break;
      }
    }while(opcion!=7);
  }
  public static void menu(){
    System.out.println("Introduce una de las opciones siguentes");
    System.out.println("1.- Agregar un nuevo material al inventario");
    System.out.println("2.- Ver listado de material disponible");
    System.out.println("3.- Buscar informacion por codigo");
    System.out.println("4.- Vender material a un cliente");
    System.out.println("5.- Consultar stock de un producto");
    System.out.println("6.- Actualizar informacion de un producto");
    System.out.println("7.- Salir");
  }
}
