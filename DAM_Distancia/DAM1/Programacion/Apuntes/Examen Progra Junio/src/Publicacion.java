/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Publicacion {
  private String cod;
  private String editorial;

  public Publicacion(){
    this.cod ="";
    this.editorial ="";
  }
  public Publicacion(String cod, String editorial) {
    this.cod = cod;
    this.editorial = editorial;
  }

  public String getCod() {
    return cod;
  }

  public void setCod(String cod) {
    this.cod = cod;
  }

  public String getEditorial() {
    return editorial;
  }

  public void setEditorial(String editorial) {
    this.editorial = editorial;
  }
  
  public void alta (String cod, String editorial){
    this.cod = cod;
    this.editorial = editorial;
  }
  
  public void modificar (String cosa){
    this.editorial += " - " + cosa;
  }
}
