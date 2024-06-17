/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package pruebas;

/**
 *
 * @author xdGHOSTbx
 */
public class Alumno {
  private String nombre;
  private String apellidos;
  private int edad;
  private String DNI;

  public Alumno(String nombre, String apellidos, int edad, String DNI) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.DNI = DNI;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getDNI() {
    return DNI;
  }

  public void setDNI(String DNI) {
    this.DNI = DNI;
  }

  @Override
  public String toString() {
    return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", DNI=" + DNI + '}';
  }
  
  
}
