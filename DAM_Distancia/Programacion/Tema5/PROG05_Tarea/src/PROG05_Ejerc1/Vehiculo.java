/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG05_Ejerc1;

import java.time.LocalDate;

public class Vehiculo {
    private String marca = "";
    private String matricula = "";
    private int numKilometros = 0;
    private LocalDate fechaMatriculacion ;
    private String descripcion = "";
    private double precio = 0;
    private String nombrePropietario = "";
    private String dniPropietario = "";
    
    public Vehiculo(String marca, String matricula, int numKilometros,
            LocalDate fechaMatriculacion, String descripcion, double precio,
            String nombrePropietario, String dniPropietario){
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getMatricula(){
        return matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    
    public int getNumKilometros() {
        return numKilometros;
    }

    public void setNumKilometros(int numKilometros) {
        this.numKilometros = numKilometros;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    public int get_Anhos(){
        LocalDate fechaActual = LocalDate.now();
        int anhosTranscurridos = fechaActual.getYear() - fechaMatriculacion.getYear();
        
        if (fechaMatriculacion.getDayOfYear() > fechaActual.getDayOfYear()) {
            anhosTranscurridos--;
        }

        return anhosTranscurridos;
    }
        
}
