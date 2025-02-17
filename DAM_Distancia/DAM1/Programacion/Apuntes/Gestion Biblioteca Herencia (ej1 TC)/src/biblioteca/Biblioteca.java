/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Biblioteca {
  ArrayList<MaterialBibliografico> materiales;
  
  public Biblioteca(){
    this.materiales = new ArrayList<>();
  }
  
  public void agregarMaterial(MaterialBibliografico material){
    materiales.add(material);
  }
  
  public void verListado(){
    for(MaterialBibliografico material : materiales){
      System.out.println(material.toString());
    }
  }
  
  public MaterialBibliografico buscarISBN(String isbn){
    for(MaterialBibliografico material : materiales){
      if (material.getIsbn().equals(isbn)){
        System.out.println("Libro encontrado");
        return material;
      }
    }
    return null;
  }
  
  public void prestarMaterial(String titulo, Usuario usuario){
    boolean encontrado = false;
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo().equals(titulo)){
        if(material.getEstado()){
          material.prestamo(usuario);
          encontrado = true;
        }else{
          System.out.println("Libro en prestamo");
        }
      }
    }
    if (!encontrado)
        System.out.println("No se ha encontrado el libro");
  }
  
  public void devolverLibro(String titulo){
    boolean encontrado = false;
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo().equals(titulo)){
        if(!material.getEstado()){
          material.devolucion();
          encontrado = true;
          break;
        }
      }
    }
    if (!encontrado)
        System.out.println("No se ha encontrado el libro");
  }
  
  public void consultarMaterial(String titulo){
    boolean encontrado = false;
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo().equals(titulo)){
        encontrado = true;
        System.out.println(material.getEstado() ? "Disponible" : "Prestado");
        break;
      }
    }
    if(!encontrado){
        System.out.println("No se puedo encontrar el titulo");
      }
  }
}
