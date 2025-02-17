
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Garaje2 {
  ArrayList<Vehiculo> garaje;
  private int capacidad;

  public Garaje2(int capacidad) {
    this.capacidad = capacidad;
    this.garaje = new ArrayList<>();
  }
  
  public void añadirCoche(Vehiculo v){
    if(garaje.size()<capacidad){
      garaje.add(v);
      System.out.println("vehiculo agregado");
    }
  }
  
  public void mostarInfo(){
    for(Vehiculo v : garaje){
      System.out.println(v.mostrarInfo());
    }
  }
}
