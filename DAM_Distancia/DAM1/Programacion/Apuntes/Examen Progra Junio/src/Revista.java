/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Revista extends Publicacion {
  private String tematica;

  public Revista(String tematica, String cod, String editorial) {
    super(cod, editorial);
    this.tematica = tematica;
  }

  public String getTematica() {
    return tematica;
  }

  public void setTematica(String tematica) {
    this.tematica = tematica;
  }

  
  public void alta(String cod, String editorial, String tematica) {
    super.alta(cod, editorial);
    this.tematica = tematica;
  }
  
  
}
