/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Estanteria;

/**
 *
 * @author xdGHOSTbx
 */
public class Producto {
  private String nombre;
  private static int indice = 0;
  private int id;

  public Producto(String nombre) {
    this.nombre = nombre;
    this.id = indice++;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "nombre=" + nombre + ", id=" + id + '}';
  }
  
  
  
}
