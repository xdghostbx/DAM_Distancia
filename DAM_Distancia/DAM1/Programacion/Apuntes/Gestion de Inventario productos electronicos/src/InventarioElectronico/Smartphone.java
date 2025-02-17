/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package InventarioElectronico;

/**
 *
 * @author xdGHOSTbx
 */
public class Smartphone extends Producto {
  private int camara;

  public Smartphone(String nombre, String marca, int codigo, double precio, int stock,int camara) {
    super(nombre, marca, codigo, precio, stock);
    this.camara = camara;
  }

  public int getCamara() {
    return camara;
  }

  public void setCamara(int camara) {
    this.camara = camara;
  }

  @Override
  public String toString() {
    return super.toString() + "camara " + camara+"Mpx\n";
  }
  
  
}
