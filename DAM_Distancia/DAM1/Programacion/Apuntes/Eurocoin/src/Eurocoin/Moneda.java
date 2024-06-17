/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Eurocoin;

/**
 *
 * @author xdGHOSTbx
 */
public class Moneda {
  private String valor;
  private String posicion;

  public Moneda(String valor, String posicion) {
    this.valor = valor;
    this.posicion = posicion;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }

  public String getPosicion() {
    return posicion;
  }

  public void setPosicion(String posicion) {
    this.posicion = posicion;
  }
  
  public String toString(){
    return valor +" - " + posicion;
  }
}
