/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Animales;

/**
 *
 * @author xdGHOSTbx
 * En esta clase definimos la estructura de los distintos animales con las que
 * trabajará el código
 */
public class Animal {
  private String raza;
  private String nombre;
  private int edad;
  private int identificador;

  public Animal(String raza, String nombre, int edad) {
    this.raza = raza;
    this.nombre = nombre;
    this.edad = edad;
    identificador++;
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

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public int getIdentificador() {
    return identificador;
  }

  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  @Override
  public String toString() {
    return "se ha añadido un " + raza;
  }
  
}
