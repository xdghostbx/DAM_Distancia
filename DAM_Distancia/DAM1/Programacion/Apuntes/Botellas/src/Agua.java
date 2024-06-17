/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Agua extends Bebida {
  private String manantial;

  public Agua(String marca, double litros, double precio, String manantial) {
    super(litros, precio, marca);
    this.manantial = manantial;
  }

  public String getManantial() {
    return manantial;
  }

  public void setManantial(String manantial) {
    this.manantial = manantial;
  }

  @Override
  public String toString() {
    return super.toString()+ " " + manantial;
  }
  
  
}
