/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package biblioteca;

/**
 *
 * @author xdGHOSTbx
 */
public class Usuario {
  private String nombre;
  private String apellido;
  private int numId;

  public Usuario(String nombre, String apellido, int numId) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.numId = numId;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getNumId() {
    return numId;
  }

  public void setNumId(int numId) {
    this.numId = numId;
  }
  
}
