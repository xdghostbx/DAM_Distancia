/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Carta;

/**
 *
 * @author xdGHOSTbx
 */

import java.util.*;

public class Carta {
  private String palo;
  private String valor;

  public Carta(String palo, String valor) {
    this.palo = palo;
    this.valor = valor;
  }

  public String getPalo() {
    return palo;
  }

  public void setPalo(String palo) {
    this.palo = palo;
  }

  public String getValor() {
    return valor;
  }

  public void setValor(String valor) {
    this.valor = valor;
  }
  
  
  
  
  public String toString(){
    return valor + " de " + palo;
  }
}
