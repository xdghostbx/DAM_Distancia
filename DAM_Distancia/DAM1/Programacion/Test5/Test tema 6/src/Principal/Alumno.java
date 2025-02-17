/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

/**
 En esta clase definimos el objeto alumno, con su constructorm setter y getters
 */
public class Alumno {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String DNI;
    private double nota;

    public Alumno(String nombre, String apellidos, String direccion, String DNI, double nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.DNI = DNI;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
     
}
