/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Estanteria;

/**
 *
 * @author xdGHOSTbx
 */
public class Bebida extends Producto {
  private String tipo;

  public Bebida(String tipo, String nombre) {
    super(nombre);
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  
  
}
