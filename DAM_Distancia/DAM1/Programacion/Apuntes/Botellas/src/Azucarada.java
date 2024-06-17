/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Azucarada extends Bebida {
  private int porc_azucar;
  private boolean promocion;

  public Azucarada(String marca, double litros, double precio, int porc_azucar, boolean promocion) {
    super(litros, precio, marca);
    this.porc_azucar = porc_azucar;
    this.promocion = promocion;
  }

  public int getPorc_azucar() {
    return porc_azucar;
  }

  public void setPorc_azucar(int porc_azucar) {
    this.porc_azucar = porc_azucar;
  }

  public boolean isPromocion() {
    return promocion;
  }

  public void setPromocion(boolean promocion) {
    this.promocion = promocion;
  }
  
  @Override
  public double getPrecio(){
    if(isPromocion()){
      return super.getPrecio()*0.9;
    }else{
      return super.getPrecio();
    }   
  }
  
  @Override
  public String toString() {
    return super.toString()+ " " +porc_azucar + "% " + promocion;
  }
  
  
}
