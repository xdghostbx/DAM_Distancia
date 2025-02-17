/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Almacen {
  private Bebida[][] almacen;

  public Almacen(int filas, int columnas) {
    this.almacen = new Bebida[filas][columnas];
  }
  
  public void nuevaBebida(Bebida bebida){
    boolean insertada = false;
    for (int i = 0; i<almacen.length && !insertada;i++){
      for (int j = 0; j<almacen[i].length && !insertada;j++){
        if(almacen[i][j] == null){
          almacen[i][j] = bebida;
          insertada = true;
        }
      }
    }
    
    if (insertada)
        System.out.println("Bebida insertada con exito");
    else if (!insertada)
        System.out.println("no se ha podido agregar la bebida");
  }
  
  public void eliminarBebida (int id){
    boolean encontrado = false;
    for (int i = 0; i<almacen.length&& !encontrado;i++){
      for (int j = 0; j<almacen[i].length&& !encontrado;j++){
        if(almacen[i][j].getId() == id){
          almacen[i][j] = null;
          encontrado = true;
        }
      }
    }
    
    if (encontrado)
        System.out.println("Se ha eliminado la bebida");
    else if (!encontrado)
        System.out.println("No se ha encontrado bebida con ese id");
  }
  
  public void mostrarInfo(){
    for (int i = 0; i<almacen.length;i++){
      for (int j = 0; j<almacen[i].length;j++){
        if(almacen[i][j]!=null){
        System.out.println( almacen[i][j].toString()); 
        }
      }
    }
  }
  
  public double calcularPrecio(){
    double precio = 0;
    boolean encotrado = false;
    for (int i = 0; i<almacen.length&& !encotrado;i++){
      for (int j = 0; j<almacen[i].length&& !encotrado;j++){
        if(almacen[i][j]!= null){
          precio += almacen[i][j].getPrecio();
        }
      }
    }
    return precio;
  }

  
  
}
