/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Zona {
  private int entradasPorVender;

  public Zona(int n) {
    this.entradasPorVender = n;
  }
  public int getEntradasPorVender(){
    return entradasPorVender;
  }
  public void vender (int n){
    if(this.entradasPorVender == 0){
      System.out.println("Entradas Agotadas");
    }else if (this.entradasPorVender < n){
      System.out.println("Solo me quendam "+this.entradasPorVender+" entradas");
    }
    
    if (this.entradasPorVender >= n){
      this.entradasPorVender -= n;
      System.out.println("Aqui tienes tus "+n+ " entradas");
    }
  }
}
