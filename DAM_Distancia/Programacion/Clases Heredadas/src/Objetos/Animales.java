/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Objetos;

/**
 *
 * @author xdGHOSTbx
 */
public class Animales {
    private String raza;
    private String nombre;
    private String sexo;

  public Animales(String raza, String nombre, String sexo) {
    this.raza = raza;
    this.nombre = nombre;
    this.sexo = sexo;
  }

  public String getRaza() {
    return raza;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  @Override
  public String toString() {
    return "Animales{" + "raza=" + raza + ", nombre=" + nombre + ", sexo=" + sexo + '}';
  }
    
    
}
