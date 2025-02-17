/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Programa;


public class Vehiculo {
    String marca = "";
    String matricula = "";
    float numKilometros = 0;
    String fecha_Matriculacion = "";
    String descripcion = "";
    float precio = 0;
    String nombrePropietario = "";
    String DNI = "";

    public Vehiculo (String marca, String matricula, float numKilometros, String fecha_Matriculacion
                    , String descripcion, float precio, String nombrePropietario, String DNI){
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fecha_Matriculacion = fecha_Matriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.DNI = DNI;
        
    }   
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getNumKilometros() {
        return numKilometros;
    }

    public void setNumKilometros(float numKilometros) {
        this.numKilometros = numKilometros;
    }

    public String getFecha_Matriculacion() {
        return fecha_Matriculacion;
    }

    public void setFecha_Matriculacion(String fecha_Matriculacion) {
        this.fecha_Matriculacion = fecha_Matriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
