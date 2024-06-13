/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

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
    Libro libro = new Libro("Mort","Pratchet","1",false);
    Libro libro2 = new Libro("Rechicero","Pratchet","2",false);
    Libro libro3 = new Libro("Papa Puerco","Pratchet","3",false);
    Libro libro4 = new Libro("God Omens","Pratchet","4",false);
    
    Usuario usuario = new Usuario("Sanda","1");
    Usuario usuario2 = new Usuario("Dani","2");
    
    biblioteca.agregarLibro(libro);
    biblioteca.agregarLibro(libro2);
    biblioteca.agregarLibro(libro3);
    biblioteca.agregarLibro(libro4);
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.agregarUsuario(usuario);
    biblioteca.agregarUsuario(usuario2);
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.buscarTitulo("Mort");
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.eliminarLibro("4");
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.prestarLibro("1", "1");
    biblioteca.prestarLibro("2", "1");
    biblioteca.prestarLibro("3", "1");
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.prestarLibro("1", "2");
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.devolverLibro("1", "1");
    
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
    biblioteca.buscarTitulo("Mort");
    System.out.println();
    System.out.println("----------------------------");
    System.out.println();
  }
  
}
