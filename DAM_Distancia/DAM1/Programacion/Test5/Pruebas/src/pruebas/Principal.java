/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package pruebas;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Aula aula = new Aula();
    String nombre = "a",  apellidos="a", DNI="a";
    int edad=0;
    Alumno alumno = new Alumno(nombre,  apellidos,  edad,  DNI);
    int nose =  aula.alumnoNuevo(alumno);
  }
  
}
