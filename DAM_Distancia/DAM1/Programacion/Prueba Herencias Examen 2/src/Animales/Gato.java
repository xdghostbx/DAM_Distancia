/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Animales;

/**
 *
 * @author xdGHOSTbx
 * En esta clase ponemos los atributos para una clase del tipo Gato
 */
public class Gato extends Animal {
  
  private String sonido;
  private String color;
  private String alimentacion;

  public Gato(String sonido, String color, String alimentacion, String raza, String nombre, int edad) {
    super(raza, nombre, edad);
    this.sonido = sonido;
    this.color = color;
    this.alimentacion = alimentacion;
  }

  public String getSonido() {
    return sonido;
  }

  public void setSonido(String sonido) {
    this.sonido = sonido;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getAlimentacion() {
    return alimentacion;
  }

  public void setAlimentacion(String alimentacion) {
    this.alimentacion = alimentacion;
  }
  
  public String sonido (String sonido){
    return "el gato hace "+sonido;
  }
  
}
