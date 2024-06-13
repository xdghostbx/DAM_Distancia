/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Moto extends Vehiculo {
  private String tipo;

  public Moto(String marca, String modelo, int año, String tipo) {
    super(marca, modelo, año);
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  @Override
  public String mostrarInfo(){
    return super.getMarca() + super.getModelo() + super.getAño() + tipo;
  }
}
