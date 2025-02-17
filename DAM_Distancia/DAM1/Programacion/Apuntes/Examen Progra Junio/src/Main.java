/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    /*
      Ejercicio 1:
        Crear un libro, darlo de alta con atributos y meter
        varios autores en el arraylist
    */
    Libro libro1 = new Libro (1, "El imperio final");
    libro1.nuevoAutor("Sanderson");
    libro1.nuevoAutor("Dragonsteel");
    
    Libro libro2 = new Libro(2, "Cien años de soledad");
    libro2.nuevoAutor("Gabriel García Márquez");
    libro2.nuevoAutor("Isabel Allende");
    
    Libro libro3 = new Libro(3,"El camino de los reyes");
    libro3.nuevoAutor("Brando");
    
    Libro libro4 = new Libro(4,"El poso de ascender");
    libro4.nuevoAutor("Sando");
    
    /*
      Ejercicio 2:
        Creamos un metodo para ver el libro, en mi caso
        devuelve todos los datos, pero se deja solo en ISBN
        que es lo que pide
    */
    System.out.println("ejecicicio2");
    String libro = libro1.verLibro();
    System.out.println(libro);
    System.out.println("");
    System.out.println("----------------------------------");
    System.out.println("");
    
    
    /*
      Ejercicio 3:
        Metodo que busca el isbn y devuelve el libro
        Hecho con arrayList y con Array normal
    */
    
    //arraylist
    Bibioteca biblioteca = new Bibioteca();
    biblioteca.agregarLibro(libro1);
    biblioteca.agregarLibro(libro2);
    biblioteca.agregarLibro(libro3);
    biblioteca.agregarLibro(libro4);
    
    System.out.println("ejecicicio3- arraylist");
    String libr = biblioteca.buscarISBN(3);
    System.out.println(libr);
        System.out.println("");
    System.out.println("----------------------------------");
    System.out.println("");
    
    //array
    BibliotecaArray biblio = new BibliotecaArray (10);
    biblio.agregarLibro(libro1);
    biblio.agregarLibro(libro2);
    biblio.agregarLibro(libro3);
    biblio.agregarLibro(libro4);
    
    String librito = biblio.buscarLibroPorISBN(2);
    /*
      si funciona correctamente tiene que devolver isbn 1 y 3
    */
    System.out.println("ejecicicio3 - array 2 libros");
    System.out.println(librito);
        System.out.println("");
    System.out.println("----------------------------------");
    System.out.println("");
    
    String librito2 = biblio.buscarLibroPorISBN(0);
    /*
      como no existe isbn 0 tendría que devolver el ultimo
    */
    System.out.println("ejecicicio3 - array ultimo libros");
    System.out.println(librito2);
        System.out.println("");
    System.out.println("----------------------------------");
    System.out.println("");
    
    /*
      Ejercicio 4 -- Insertar una Publicacion, una revista y un periodico
    */
    
    Publicacion publicacion = new Publicacion();
    publicacion.alta("a","a");
  }
  
  
  

}
