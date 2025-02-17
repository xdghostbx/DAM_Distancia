/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Operaciones;

/**
 *
 * @author xdGHOSTbx
 */
public class Alumno {
  private String dni;
  private String nombre;
  private String apellios;
  private int edad;

  public Alumno(String dni, String nombre, String apellios, int edad) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellios = apellios;
    this.edad = edad;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellios() {
    return apellios;
  }

  public void setApellios(String apellios) {
    this.apellios = apellios;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Alumno{" + "dni=" + dni + ", nombre=" + nombre + ", apellios=" + apellios + ", edad=" + edad + '}';
  }
  
  
}
