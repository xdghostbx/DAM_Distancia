/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Biblioteca;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Biblioteca {
  ArrayList<Libro> libros;

  public Biblioteca() {
    this.libros = new ArrayList<>();
  }
  
  public void agregarLibro(Libro libro){
    libros.add(libro);
  }
  public void obtenerLibros(){
    for (Libro libro:libros){
      System.out.println(libro.toString());
    }
  }
  
  public int calcularPaginas(){
    int paginasTotales = 0;
    for (Libro libro : libros){
      paginasTotales += libro.getPaginas();
    }
    
    return paginasTotales;
  }
}
