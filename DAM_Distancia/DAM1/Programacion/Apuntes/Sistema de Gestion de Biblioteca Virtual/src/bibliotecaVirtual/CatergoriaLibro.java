/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package bibliotecaVirtual;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xdGHOSTbx
 */
public class CatergoriaLibro {
  private String nombreCategoría;
  ArrayList<Libro> libros;

  public CatergoriaLibro(String nombreCategoría) {
    this.nombreCategoría = nombreCategoría;
    this.libros = new ArrayList<>();
  }
  
  public void agregarLibro(Libro libro){
    libros.add(libro);
  }
}
