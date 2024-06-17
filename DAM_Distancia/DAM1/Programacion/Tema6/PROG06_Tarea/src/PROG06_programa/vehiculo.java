/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG06_programa;

import java.time.LocalDate;

public class vehiculo {
    private String marca;
    private String matricula;
    private int numKilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private int dniPropietario;

    public vehiculo(String marca, String matricula, int numKilometros, LocalDate fechaMatriculacion, String descripcion, double precio, String nombrePropietario, int dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
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

    public int getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    public int getAnhos() {
        LocalDate fechaActual = LocalDate.now();
        int anhosTranscurridos = fechaActual.getYear() - fechaMatriculacion.getYear();

        if (fechaMatriculacion.getDayOfYear() > fechaActual.getDayOfYear()) {
            anhosTranscurridos--;
        }

        return anhosTranscurridos;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "marca='" + marca + '\'' +
                ", matricula='" + matricula + '\'' +
                ", numKilometros=" + numKilometros +
                ", fechaMatriculacion=" + fechaMatriculacion +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", nombrePropietario='" + nombrePropietario + '\'' +
                ", dniPropietario=" + dniPropietario +
                '}';
    }
}