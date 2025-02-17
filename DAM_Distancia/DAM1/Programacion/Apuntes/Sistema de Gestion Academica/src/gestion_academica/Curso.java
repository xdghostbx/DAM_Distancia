/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package gestion_academica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xdGHOSTbx
 */
public class Curso {
  private String nombreCurso;
  private List<Estudiante> estudiantes;
  
  public Curso(String nombreCurso){
    this.nombreCurso = nombreCurso;
    this.estudiantes = new ArrayList<>();
  }

  public String getNombreCurso() {
    return nombreCurso;
  }

  public void setNombreCurso(String nombreCurso) {
    this.nombreCurso = nombreCurso;
  }

  public List<Estudiante> getEstudiantes() {
    return estudiantes;
  }

  public void agregarEstudiante(Estudiante estudiante){
    estudiantes.add(estudiante);
  }
  
  public double calcularMediaCurso(){
    double sumaMedias = 0;
    double mediaFinal = 0;
    for(Estudiante estudiante : estudiantes){
      sumaMedias += estudiante.calcularMedia();
    }
    
    if(estudiantes.size()>0){
      mediaFinal = sumaMedias / estudiantes.size();
    }else
        mediaFinal = 0;
    
    return mediaFinal;
  }
  
}
