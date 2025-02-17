/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package biblioteca;

/**
 *
 * @author xdGHOSTbx
 */
public class MaterialBibliografico {
  private String titulo;
  private String autor;
  private String isbn;
  private int anho;
  private boolean estado;
  private String usuario;

  public MaterialBibliografico(String titulo, String autor, String isb, int anho) {
    this.titulo = titulo;
    this.autor = autor;
    this.isbn = isb;
    this.anho = anho;
    this.estado = true;
    this.usuario = null;
  }

  @Override
  public String toString() {
    return String.format("Título: %s\nAutor: %s\nISBN: %s\nAño de Publicación: %d\nDisponible: %s\n",
        titulo, autor, isbn, anho, estado ? "Sí" : "No");
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitulo() {
    return titulo;
  }
  
  
  public boolean getEstado() {
    return estado;
  }

  public void prestamo(Usuario us){
    if(estado){
      this.estado = false;
      this.usuario = us.getNombre();
    }else
        System.out.println("Libro en prestamo");
  }
  
  public void devolucion(){
    this.estado = true;
    this.usuario = null;
  }
  
}
