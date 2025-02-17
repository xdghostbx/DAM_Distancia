
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Bibioteca {
  ArrayList<Libro> biblioteca;

  public Bibioteca() {
    this.biblioteca = new ArrayList<>();
  }
  
  public void agregarLibro(Libro libros){
    biblioteca.add(libros);
  }
  
  public String buscarISBN (int ISBN){
    boolean encontrado = false;
    String a = "";
    for(Libro libros : biblioteca){
      if(libros.getISBN() == ISBN){
        encontrado = true;
        a = libros.verLibro();
        break;
      }
      if (!encontrado){
        a = "No se ha encontrado el libro";
      }
    }
    return a;
  }
}
