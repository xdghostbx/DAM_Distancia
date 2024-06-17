/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Gestion_Biblioteca;

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    Biblioteca biblioteca = new Biblioteca();
    
    Libro cosmere1 = new Libro("El imperio final","Sanderson",600);
    Libro cosmere2 = new Libro("El pozo de la ascension","Sanderson",650);
    
    biblioteca.agregarLibro(cosmere2);
    biblioteca.agregarLibro(cosmere1);
    
    int paginas = biblioteca.calcularPaginas();
    System.out.println(paginas);
  }
  
  
}
