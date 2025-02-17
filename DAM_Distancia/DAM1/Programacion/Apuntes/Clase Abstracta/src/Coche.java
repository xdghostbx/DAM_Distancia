/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Coche extends Vehiculo {

  private int numPuertas;

  public Coche(String marca, String modelo, int año, int numPuertas) {
    super(marca, modelo, año);
    this.numPuertas = numPuertas;
  }

  public int getNumPuertas() {
    return numPuertas;
  }

  public void setNumPuertas(int numPuertas) {
    this.numPuertas = numPuertas;
  }

  @Override
  public String mostrarInfo() {
    return super.getMarca() + super.getModelo() + super.getAño() + numPuertas;
  }
}
