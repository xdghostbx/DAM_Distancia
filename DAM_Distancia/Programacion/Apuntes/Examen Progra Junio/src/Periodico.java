/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Periodico extends Publicacion{
  private String idioma;

  public Periodico(String idioma, String cod, String editorial) {
    super(cod, editorial);
    this.idioma = idioma;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public void alta(String cod, String editorial, String idima) {
    super.alta(cod, editorial);
    this.idioma = idioma;
  }
  
  
}
