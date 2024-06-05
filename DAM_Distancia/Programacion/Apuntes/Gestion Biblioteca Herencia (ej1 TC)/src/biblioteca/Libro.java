/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package biblioteca;

/**
 *
 * @author xdGHOSTbx
 */
public class Libro extends MaterialBibliografico {
  private int numPaginas;

  public Libro(int numPaginas, String titulo, String autor, String isb, int anho) {
    super(titulo, autor, isb, anho);
    this.numPaginas = numPaginas;
  }

  @Override
  public String toString() {
    return super.toString() + String.format("Numero de paginas: %d\n", numPaginas);
  }
  
  
}
