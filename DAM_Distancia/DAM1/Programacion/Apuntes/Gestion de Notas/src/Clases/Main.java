/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    GestionNotas gestion = new GestionNotas();
    
    Estudiante a = new Estudiante("Dani",1);
    Estudiante b = new Estudiante("Daniel",2);
    
    gestion.agregarEstudiante(a);
    gestion.agregarEstudiante(b);
    
    gestion.asignarNota(1, "mates", 5);
    gestion.asignarNota(1, "historia", 5);
    gestion.asignarNota(1, "lengua", 5);
    
    System.out.println("Notas de dani");
    gestion.notasEstudiante(1);
    System.out.println();
    
    System.out.println("media de dani");
    System.out.println(gestion.calcularPromedioEstudiante(1));
    
    System.out.println("");
    System.out.println(gestion.buscarPorNombre("Daniel"));
  }
  
}
