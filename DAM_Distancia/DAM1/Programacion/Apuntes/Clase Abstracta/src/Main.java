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
    Coche coche1 = new Coche("Seat","Ibiza",2001,4);
    Moto moto1 = new Moto ("Suzuki","Marauder",2007,"Custom");
    
    Garaje garaje = new Garaje(10);
    Garaje2 g = new Garaje2(5);
    
    System.out.println(coche1.mostrarInfo());
    System.out.println(moto1.mostrarInfo());
    
    garaje.agregarVehiculo(moto1);
    garaje.agregarVehiculo(coche1);
    
    g.añadirCoche(coche1);
    g.añadirCoche(moto1);
    
    garaje.mostrarVehiculos();
    g.mostarInfo();
  }
  
}
