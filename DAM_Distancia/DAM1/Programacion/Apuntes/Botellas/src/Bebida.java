/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Bebida {
  private static int id0 = 1;
  private int id;
  private double litros;
  private double precio;
  private String marca;

  public Bebida( double litros, double precio, String marca) {
    this.id = id0++;
    this.litros = litros;
    this.precio = precio;
    this.marca = marca;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getLitros() {
    return litros;
  }

  public void setLitros(double litros) {
    this.litros = litros;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  public String toString(){
    return marca + " - " + id+" "+litros+" "+precio+"€";
  }
}
