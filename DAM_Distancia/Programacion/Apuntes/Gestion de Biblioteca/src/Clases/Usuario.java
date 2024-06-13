/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Usuario {
  private String nombre;
  private String idUs;
  private ArrayList<Libro> prestados;

  public Usuario(String nombre, String idUs) {
    this.nombre = nombre;
    this.idUs = idUs;
    this.prestados = new ArrayList<>();
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getIdUs() {
    return idUs;
  }

  public void setIdUs(String idUs) {
    this.idUs = idUs;
  }

  public void prestarLibro (Libro libro){
    if(!libro.isPrestado()){
      libro.setPrestado(true);
      prestados.add(libro);
    }
  }
  
  public void devolverLibro (Libro libro){
    if(prestados.remove(libro)){
      libro.setPrestado(false);
    }
  }

  @Override
  public String toString() {
    return "Usuario{" + "nombre=" + nombre + ", idUs=" + idUs + ", prestados=" + prestados + '}';
  }
  
  
}
