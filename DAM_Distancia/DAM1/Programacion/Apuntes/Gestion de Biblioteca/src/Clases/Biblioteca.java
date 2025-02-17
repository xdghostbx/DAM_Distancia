/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Biblioteca {
  ArrayList<Libro> catalogo;
  ArrayList<Usuario> usuarios;

  public Biblioteca() {
    this.catalogo = new ArrayList<>();
    this.usuarios = new ArrayList<>();
  }
  
  public void agregarLibro(Libro libro){
    catalogo.add(libro);
    System.out.println("Nuevo libro agregado");
  }
  
  public void agregarUsuario(Usuario usuario){
    usuarios.add(usuario);
    System.out.println("Nuevo usuario agregado");
  }
  
  public void eliminarLibro (String isbn){
    boolean encontrado = false;
    for (Libro libro : catalogo){
      if(libro.getIsbn().equals(isbn)){
        catalogo.remove(libro);
        System.out.println("Se ha eliminado el libro");
        encontrado = true;
        break;
      }
    }
    if(!encontrado){
      System.out.println("No se ha ncontrado el libro");
    }
  }
  
  public void buscarTitulo (String titulo){
    boolean encontrado = false;
    for (Libro libro : catalogo){
      if(libro.getTitulo().equals(titulo)){
        System.out.print(libro.getTitulo()+" - ");
        System.out.print(libro.isPrestado()?"Prestado":"Disponible");
        encontrado = true;
        break;
      }
    }
    if(!encontrado){
      System.out.println("No se ha ncontrado el libro");
    }
  }
  
  public void prestarLibro (String isbn, String id){
    boolean encontrado = false;
    for (Libro libro : catalogo){
      if(libro.getIsbn().equals(isbn)){
        for(Usuario usuario : usuarios){
          if(usuario.getIdUs().equals(id)){
            if(!libro.isPrestado()){
              usuario.prestarLibro(libro);
              System.out.println("Se ha prestado el libro");
              encontrado = true;
              break;
            }else{
              System.out.println("El libro ya está prestado");
              encontrado = true;
              break;
            }
          }
        }
      }
    }
    if(!encontrado){
      System.out.println("No se ha ncontrado el libro");
    }
  }
  
  public void devolverLibro(String isbn, String id){
    boolean encontrado = false;
    for (Libro libro : catalogo){
      if(libro.getIsbn().equals(isbn)){
        for(Usuario usuario : usuarios){
          if(usuario.getIdUs().equals(id)){
            if(libro.isPrestado()){
              usuario.devolverLibro(libro);
              System.out.println("se ha devuelto el libro");
              encontrado = true;
              break;
            }else{
              System.out.println("El libro no está prestado");
              encontrado = true;
              break;
            }
          }
        }
      }
    }
    if(!encontrado){
      System.out.println("No se ha ncontrado el libro");
    }
  }
}
