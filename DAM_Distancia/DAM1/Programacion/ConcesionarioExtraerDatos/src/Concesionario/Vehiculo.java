/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Concesionario;

import java.io.Serializable;

/**
 *
 * @author xdGHOSTbx
 */
public class Vehiculo implements Serializable {
  private String matricula;
  private String marca;
  private String descripcion;
  private double kms;
  private double precio;

  public Vehiculo(String matricula, String marca, String descripcion, double kms, double precio) {
    this.matricula = matricula;
    this.marca = marca;
    this.descripcion = descripcion;
    this.kms = kms;
    this.precio = precio;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public double getKms() {
    return kms;
  }

  public void setKms(double kms) {
    this.kms = kms;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Vehiculo{" + "matricula=" + matricula + ", marca=" + marca + ", descripcion=" + descripcion + ", kms=" + kms + ", precio=" + precio + '}';
  }
 
  
}
