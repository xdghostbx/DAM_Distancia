/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package modelo;

/**
 *
 * @author xdGHOSTbx
 */
public class Propietarios {
  private int id_prop;
  private String nombre_prop;
  private String dni_prop;

  public Propietarios(int id_prop, String nombre_prop, String dni_prop) {
    this.id_prop = id_prop;
    this.nombre_prop = nombre_prop;
    this.dni_prop = dni_prop;
  }

  public int getId_prop() {
    return id_prop;
  }

  public void setId_prop(int id_prop) {
    this.id_prop = id_prop;
  }

  public String getNombre_prop() {
    return nombre_prop;
  }

  public void setNombre_prop(String nombre_prop) {
    this.nombre_prop = nombre_prop;
  }

  public String getDni_prop() {
    return dni_prop;
  }

  public void setDni_prop(String dni_prop) {
    this.dni_prop = dni_prop;
  }
  
  
  
}
