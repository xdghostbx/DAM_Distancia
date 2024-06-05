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
      if (material.getIsbn() == isbn){
        System.out.println("Libro encontrado");
        return material;
      }
    }
    return null;
  }
  
  public void prestarMaterial(String titulo, Usuario usuario){
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo() == titulo){
        if(material.getEstado() == true){
          material.prestamo(usuario);
        }else{
          System.out.println("Libro en prestamo");
        }
      }else{
        System.out.println("No se puedo encontrar el titulo");
      }
    }
  }
  
  public void devolverLibro(String titulo){
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo() == titulo){
        if(material.getEstado() == false){
          material.devolucion();
        }else{
          System.out.println("No se ha podido devolver el titulo");
        }
      }else{
        System.out.println("No se puedo encontrar el titulo");
      }
    }
  }
  
  public void consultarMaterial(String titulo){
    for(MaterialBibliografico material : materiales){
      if (material.getTitulo() == titulo){
        System.out.println(material.getEstado() ? "Disponible" : "Prestado");
      }else{
        System.out.println("No se puedo encontrar el titulo");
      }
    }
  }
}
