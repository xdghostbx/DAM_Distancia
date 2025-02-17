/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public abstract class Vehiculo {
  public static int kilometrosTotales;
  public static int vehiculosCreados;
  
  private int kilometrosRecorridos;

  public Vehiculo() {
    this.kilometrosRecorridos = 0;
  }

  public static int getKilometrosTotales() {
    return Vehiculo.kilometrosTotales;
  }

  public int getKilometrosRecorridos() {
    return this.kilometrosRecorridos;
  }
  
  public void recorre(int k){
    this.kilometrosRecorridos += k;
    Vehiculo.kilometrosTotales += k;
  }
  
}
