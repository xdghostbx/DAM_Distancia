/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    Scanner e = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();
    
    biblioteca.agregarMaterial( new Libro (1400, "El ritmo de la guerra","Sanderson","12345",2010));
    biblioteca.agregarMaterial( new Libro (1300, "El archivo de las tormentas","Sanderson","12346",2010));
    biblioteca.agregarMaterial( new Libro (1200, "Palabras radiantes","Sanderson","12347",2010));
    biblioteca.agregarMaterial( new Libro (1100, "Juramentada","Sanderson","12348",2010));
    
    int opcion = 0;
    do{
      menu();
      opcion = e.nextInt();
      e.nextLine();
      
      switch(opcion){
        case 1: //introducir nuevo material en el inventario
          System.out.println("Introduce los siguientes datos");
          
          System.out.println("Numero de páginas");
          int paginas = e.nextInt();
          e.nextLine();
          
          System.out.println("Titulo del libro");
          String titulo = e.nextLine();
          
          System.out.println("Autor del libro");
          String autor = e.nextLine();
          
          System.out.println("ISBN del libro");
          String ISBN = e.nextLine();
          
          System.out.println("Año de publicacion");
          int anho = e.nextInt();
          e.nextLine();
          
          biblioteca.agregarMaterial(new Libro(paginas,titulo,autor,ISBN,anho));
          break;
        case 2://mostrar material dentro del inventario
          biblioteca.verListado();
          break;
        case 3://mostrar informacion por ISBN
          System.out.println("Introduce un ISBN a buscar en el inventario");
          ISBN = e.nextLine();
          MaterialBibliografico material = biblioteca.buscarISBN(ISBN);
          if (material != null){
            System.out.println(material.toString());
          }else
              System.out.println("Material no encontrado");
          break;
        case 4://prestar libro
          System.out.println("Introduce el nombre de un libro a prestar");
          titulo = e.nextLine();
          System.out.println("Introduce el nombre de usuario");
          String nombre = e.nextLine();
          System.out.print("Ingrese el apellido del usuario: ");
          String apellido = e.nextLine();
          System.out.print("Ingrese el número de identificación del usuario: ");
          int numeroIdentificacion = e.nextInt();
          e.nextLine();
          
          Usuario usuario = new Usuario (nombre, apellido, numeroIdentificacion);
          
          biblioteca.prestarMaterial(titulo, usuario);
          break;
        case 5://devolver material
          System.out.println("Introduce el titulo del libro a devolver");
          titulo = e.nextLine();
          biblioteca.devolverLibro(titulo);
          break;
        case 6://buscar material por titulo
          System.out.println("Introduce el titulo del libro para comprobar su estado");
          titulo = e.nextLine();
          biblioteca.consultarMaterial(titulo);
          break;
        case 7:
          System.out.println("saliendo...");
          break;
        default:
          System.out.println("introduce una opcion correcta...");
            break;
      }
    }while(opcion != 7);
    
    
  }
  
  public static void menu(){
    System.out.println("Introduce una de las opciones siguentes");
    System.out.println("1.- Agregar un nuevo material al inventario");
    System.out.println("2.-Ver listado de material disponible");
    System.out.println("3.- Buscar informacion por ISBN");
    System.out.println("4.- Prestar material a un usuario");
    System.out.println("5.- Devolver material prestado");
    System.out.println("6.- Consultar material disponible");
    System.out.println("7.- Salir");
  }
}
