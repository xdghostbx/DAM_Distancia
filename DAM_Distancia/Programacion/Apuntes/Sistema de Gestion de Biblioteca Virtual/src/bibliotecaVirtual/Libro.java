/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package bibliotecaVirtual;

/**
 *
 * @author xdGHOSTbx
 */
public class Libro {
  private String titulo;
  private String autor;
  private int anhoPublicacion;
  private String categoria;
  private boolean disponible;

  public Libro(String titulo, String autor, int anhoPublicacion, String categoria, boolean disponible) {
    this.titulo = titulo;
    this.autor = autor;
    this.anhoPublicacion = anhoPublicacion;
    this.categoria = categoria;
    this.disponible = disponible;
  }

  public boolean isDisponible() {
    return disponible;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }
  
}
