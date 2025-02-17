/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 *
 * Autor: Daniel Martínez
 * Esta clase consta de los contructores, getters y setters. Se inicializa
 * la clase Vehiculo con los datos que pide el enunciado en blanco o = 0
 * A mayores, hay un metodo para calcular los años de matriculacion del coche
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
    private int dniPropietario = 0;
    
    // Constructor de la clase Vehiculo para inicializar los atributos
    public Vehiculo(String marca, String matricula, int numKilometros,
            LocalDate fechaMatriculacion, String descripcion, double precio,
            String nombrePropietario, int dniPropietario){
        this.marca = marca;
        this.matricula = matricula;
        this.numKilometros = numKilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }
    
    // Métodos getter y setter para cada atributo del vehículo
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

    public int getDniPropietario() {
        return dniPropietario;
    }

    public void setDniPropietario(int dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    public int get_Anhos(){
        LocalDate fechaActual = LocalDate.now();
        //Comparamos los años de la fecha actual y el año de matriculacion y restamos para saber los años
        int anhosTranscurridos = fechaActual.getYear() - fechaMatriculacion.getYear();
        /*Si el día introducido es mayor al de la fecha actual, significa que no pasa un año
        por lo tanto resto 1*/
        if (fechaMatriculacion.getDayOfYear() > fechaActual.getDayOfYear()) {
            anhosTranscurridos--;
        }

        return anhosTranscurridos;
    }
        
}
