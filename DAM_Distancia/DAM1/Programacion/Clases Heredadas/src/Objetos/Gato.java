/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Objetos;

/**
 *
 * @author xdGHOSTbx
 */
public class Gato extends Animales {
  private int edad;
  private String color;

  public Gato(int edad, String color, String raza, String nombre, String sexo) {
    super(raza, nombre, sexo);
    this.edad = edad;
    this.color = color;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  @Override
  public String toString() {
    return super.toString()+"Gato{" + "edad=" + edad + ", color=" + color + '}';
  }
  
  
}
