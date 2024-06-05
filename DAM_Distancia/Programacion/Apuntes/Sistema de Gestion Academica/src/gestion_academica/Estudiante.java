/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package gestion_academica;

/**
 *
 * @author xdGHOSTbx
 * 
 * Clase estudiante con los atributos:
 *  nombre, numero de indentificacion y array con sus notas
 * Getters y Setters
 */

import java.util.ArrayList;
import java.util.List;


public class Estudiante {
  private static int indice = 0;
  private String nombre;
  private int id;
  private List<Double> notas;

  public Estudiante(String nombre) {
    this.nombre = nombre;
    this.notas = new ArrayList<>();
    this.id = indice++;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Double> getNotas() {
    return notas;
  }

  public void agregarNota(double nota){
    notas.add(nota);
  }
  
  public double calcularMedia(){
    double suma = 0;
    double notaFinal = 0;
    for (double nota: notas){
      suma += nota;
    }
    if (notas.size()>0){
      notaFinal = suma/notas.size();
    }else
      notaFinal = 0;
    
    return notaFinal;
  }
  
  
  
  
}
