/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package InventarioElectronico;

/**
 *
 * @author xdGHOSTbx
 */
public class Producto implements Imprimible{
  private String nombre;
  private String marca;
  private int codigo;
  private double precio;
  private boolean estado;
  private int stock;

  public Producto(String nombre, String marca, int codigo, double precio, int stock) {
    this.nombre = nombre;
    this.marca = marca;
    this.codigo = codigo;
    this.precio = precio;
    this.estado = true;
    this.stock = stock;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public boolean getEstado() {
    return estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return String.format("Nombre %s\nMarca %s\nCodigo %s\nPrecio %s\nCantidad %s\nEstado %s\n",
            nombre,marca,codigo,precio,stock, estado ? "disponible" : "fuera de Stock" );
  }
  
  
}
