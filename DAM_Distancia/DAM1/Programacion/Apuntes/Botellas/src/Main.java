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
    Almacen almacen = new Almacen(5,5);
    double precio = 0;
    almacen.nuevaBebida(new Agua("Bezoya",1.50,2.00,""));
    almacen.nuevaBebida(new Agua("Fontecelta",1.50,2.00,""));
    almacen.nuevaBebida(new Agua("Paraño",1.50,2.00,""));
    almacen.nuevaBebida(new Agua("Aquaservice",1.50,2.00,""));
    
    almacen.nuevaBebida(new Azucarada("Pepsi",1.00,2.00,10,true));
    almacen.nuevaBebida(new Azucarada("Cocacola",1.00,2.00,10,true));
    almacen.nuevaBebida(new Azucarada("Aquarius",1.00,2.00,10,true));
    almacen.nuevaBebida(new Azucarada("Monster",1.00,2.00,10,true));
    almacen.nuevaBebida(new Azucarada("Nestea",1.00,2.00,10,true));
    System.out.println("");
    almacen.mostrarInfo();
    System.out.println("");
    
    precio = almacen.calcularPrecio();
    System.out.println(String.format("%.2f",precio));
    almacen.eliminarBebida(8);
    System.out.println("");
    almacen.mostrarInfo();
    System.out.println("");
    precio = almacen.calcularPrecio();
    System.out.println(String.format("%.2f",precio));
  }
  
}
