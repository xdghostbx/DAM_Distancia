/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Coche extends Vehiculo {
  private String tipoDeCoche;

  public Coche(String tipoDeCoche) {
    super();
    this.tipoDeCoche = tipoDeCoche;
  }

  
  public void derrapa(){
    System.out.println("Derrapandooooo");
  }
  
}
