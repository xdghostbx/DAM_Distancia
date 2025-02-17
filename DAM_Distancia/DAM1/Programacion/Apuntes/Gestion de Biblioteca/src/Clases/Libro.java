/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

/**
 *
 * @author xdGHOSTbx
 */
public class Libro {
  private String titulo;
  private String autor;
  private String isbn;
  private boolean prestado;

  public Libro(String titulo, String autor, String isbn, boolean prestado) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isbn;
    this.prestado = prestado;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAutor() {
    return autor;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public boolean isPrestado() {
    return prestado;
  }

  public void setPrestado(boolean prestado) {
    this.prestado = prestado;
  }

  @Override
  public String toString() {
    return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + ", prestado=" + prestado + '}';
  }
  
  
}
