/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package bibliotecaVirtual;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class BibliotecaVirtual {
  ArrayList<CatergoriaLibro> categorias;

  public BibliotecaVirtual() {
    this.categorias = new ArrayList<>();
  }
  
  public void agregarCategoría(CatergoriaLibro categoria){
    categorias.add(categoria);
  }
  
  public double calcularPorcentaje(){
    int librosDisponibles = 0;
    int librosTotales = 0;
    
    for(CatergoriaLibro categoria : categorias){
      for (Libro libro : categoria.libros ){
        librosTotales++;
        if (libro.isDisponible()){
          librosDisponibles++;
        }
      }
    }
    return ((double)librosDisponibles / librosTotales) * 100;
  }
}
