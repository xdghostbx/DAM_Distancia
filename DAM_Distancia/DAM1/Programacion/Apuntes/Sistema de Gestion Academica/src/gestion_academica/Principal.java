/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package gestion_academica;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Estudiante alumno1 = new Estudiante("Pepito");
    Estudiante alumno2 = new Estudiante("Juanito");
    
    alumno1.agregarNota(5);
    alumno1.agregarNota(6.5);
    alumno1.agregarNota(4.8);
    alumno1.agregarNota(7);
    alumno1.agregarNota(9.8);
    
    
    alumno2.agregarNota(6);
    alumno2.agregarNota(7.2);
    alumno2.agregarNota(10);
    alumno2.agregarNota(9.1);
    alumno2.agregarNota(3.5);
    
    Curso programacion = new Curso("Programacion");
    programacion.agregarEstudiante(alumno2);
    programacion.agregarEstudiante(alumno1);
    
    double mediaProgra = programacion.calcularMediaCurso();
    System.out.println(mediaProgra);
    
  }
  
}
