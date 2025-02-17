/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

/**
 *
 * @author xdGHOSTbx
 */
public class Alumno {
    String nombre;
    String apellidos;
    String ciudad;
    String pais;
    String DNI;
    String mail;
    float nota1, nota2, nota3, nota4, nota5;

    public Alumno(String nombre, String apellidos, String ciudad, String pais, String DNI, String mail, float nota1, float nota2, float nota3, float nota4, float nota5) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.pais = pais;
        this.DNI = DNI;
        this.mail = mail;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.nota5 = nota5;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }
    
    public float getNota5() {
        return nota5;
    }

    public void setNota5(float nota5) {
        this.nota5 = nota5;
    }
        
}
