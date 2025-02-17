
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Libro {
  private int ISBN;
  private String titulo;
  private ArrayList<String> autores;

  public Libro(int ISBN, String titulo) {
    this.ISBN = ISBN;
    this.titulo = titulo;
    this.autores = new ArrayList<>();
  }
  
  public void nuevoAutor(String autor){
    autores.add(autor);
  }

  public int getISBN() {
    return ISBN;
  }

  public void setISBN(int ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String verLibro(){
    return "Libro: " + "ISBN = " + ISBN + ", titulo = " + titulo + ", autores = " + autores;
  }
  
}
