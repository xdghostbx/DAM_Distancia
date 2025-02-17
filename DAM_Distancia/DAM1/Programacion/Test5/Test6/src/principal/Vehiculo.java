/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package principal;


public class Vehiculo {
    String marca = "";
    String matricula = "";
    float kilometros = 0;
    String fecha = "";
    String descripcion = "";
    float precio = 0;
    String nombre = "";
    String DNI = "";

    public Vehiculo (String marca, String matricula, float kilometros, String fecha
                    , String descripcion, float precio, String nombre, String DNI){
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombre = nombre;
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

    public float getKilometros() {
        return kilometros;
    }

    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}
