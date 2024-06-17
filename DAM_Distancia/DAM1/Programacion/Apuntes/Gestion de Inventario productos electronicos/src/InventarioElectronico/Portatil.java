/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package InventarioElectronico;

/**
 *
 * @author xdGHOSTbx
 */
public class Portatil extends Producto {
  private int pulgadas;

  public Portatil( String nombre, String marca, int codigo, double precio, int stock,int pulgadas) {
    super(nombre, marca, codigo, precio, stock);
    this.pulgadas = pulgadas;
  }

  public int getPulgadas() {
    return pulgadas;
  }

  public void setPulgadas(int pulgadas) {
    this.pulgadas = pulgadas;
  }

  @Override
  public String toString() {
    return super.toString() + "pulgadas " + pulgadas+"'\n";
  }
  
  
}
