/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package tablaconcesionario;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author xdGHOSTbx
 */
public class Vehiculo {
  private SimpleStringProperty marca;
  private SimpleStringProperty matricula;
  private SimpleIntegerProperty numKilometros;
  private SimpleStringProperty descripcion;
  private SimpleDoubleProperty precio;
  private SimpleStringProperty nombrePropietario;
  private SimpleStringProperty dniPropietario;

  public Vehiculo (String marca, String matricula, int numKilometros, String descripcion, double precio, String nombrePropietario, String dniPropietario){
    this.marca = new SimpleStringProperty(marca);
    this.matricula = new SimpleStringProperty(matricula);
    this.numKilometros = new SimpleIntegerProperty(numKilometros);
    this.descripcion = new SimpleStringProperty(descripcion);
    this.precio = new SimpleDoubleProperty(precio);
    this.nombrePropietario = new SimpleStringProperty(nombrePropietario);
    this.dniPropietario = new SimpleStringProperty(dniPropietario);
  }
//marca
  public SimpleStringProperty marcaProperty() {
    return marca;
  }
  public String getMarca() {
        return marca.get();
  }
  public void setMarca(String marca) {
    this.marca.set(marca);
  }
//matricula
  public SimpleStringProperty matriculaProperty() {
    return matricula;
  }
  public String getMatricula() {
        return matricula.get();
  }
  public void setMatricula(String matricula) {
    this.matricula.set(matricula);
  }
//kilometros
  public SimpleIntegerProperty numKilometros() {
    return numKilometros;
  }
  public int getNumKilometros() {
        return numKilometros.get();
  }
  public void setNumKilometros(int numKilometros) {
    this.numKilometros.set(numKilometros);
  }
  public ObservableValue<Integer> getKilometrosAsObservable() {
        return new ReadOnlyObjectWrapper<>(numKilometros.get());
  }
//descripcion
  public SimpleStringProperty descripcionProperty() {
    return descripcion;
  }
  public String getDescripcion() {
        return descripcion.get();
  }
  public void setDescripcion(String descripcion) {
    this.descripcion.set(descripcion);
  }
  //precio
  public SimpleDoubleProperty precio() {
    return precio;
  }
  public double getPrecio() {
        return precio.get();
  }
  public void setPrecio(double precio) {
    this.precio.set(precio);
  }
  public ObservableValue<Double> getPrecioAsObservable() {
        return new ReadOnlyObjectWrapper<>(precio.get());
  }
//nombre
  public SimpleStringProperty nombrePropietarioProperty() {
    return nombrePropietario;
  }
  public String getNombrePropietario() {
        return nombrePropietario.get();
  }
  public void setNombrePropietario(String nombrePropietario) {
    this.nombrePropietario.set(nombrePropietario);
  }
//dni
  public SimpleStringProperty dniPropietarioProperty() {
    return dniPropietario;
  }
  public String getDniPropietario() {
        return dniPropietario.get();
  }
  public void setDniPropietario(String dniPropietario) {
    this.dniPropietario.set(dniPropietario);
  }
}
