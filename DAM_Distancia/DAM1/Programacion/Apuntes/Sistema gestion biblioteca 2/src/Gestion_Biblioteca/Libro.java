/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Biblioteca;

/**
 *
 * @author xdGHOSTbx
 */
public class Libro {
  private String autor;
  private String titulo;
  private int paginas;

  public Libro(String autor, String titulo, int paginas) {
    this.autor = autor;
    this.titulo = titulo;
    this.paginas = paginas;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getPaginas() {
    return paginas;
  }

  public void setPaginas(int paginas) {
    this.paginas = paginas;
  }

  @Override
  public String toString() {
    return "Libro{" + "autor=" + autor + ", titulo=" + titulo + ", paginas=" + paginas + '}';
  }
  
  
}
