/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Almacen;

/**
 *
 * @author xdGHOSTbx
 */
public class Productos {
  private String codigo;
  private String nombre;
  private int cantidad;
  private double precio;

  public Productos(String codigo, String nombre, int cantidad, double precio) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.cantidad = cantidad;
    this.precio = precio;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Productos{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + '}';
  }
  
  
  
}
