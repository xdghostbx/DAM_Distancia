/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package modelo;

/**
 *
 * @author xdGHOSTbx
 */
public class vehiculos {
  private String matricula;
  private String marca;
  private float kms;
  private float precio;
  private String descripcion;
  private int id_prop;

  public vehiculos(String matricula, String marca, float kms, float precio, String descripcion, int id_prop) {
    this.matricula = matricula;
    this.marca = marca;
    this.kms = kms;
    this.precio = precio;
    this.descripcion = descripcion;
    this.id_prop = id_prop;
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

  public float getKms() {
    return kms;
  }

  public void setKms(float kms) {
    this.kms = kms;
  }

  public float getPrecio() {
    return precio;
  }

  public void setPrecio(float precio) {
    this.precio = precio;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public int getId_prop() {
    return id_prop;
  }

  public void setId_prop(int id_prop) {
    this.id_prop = id_prop;
  }
  
  
}
