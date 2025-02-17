/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package com.prog03.figuras;

/**
 *
 * @author xdGHOSTbx
 */
public class Rectangulo {
    private float altura;
    private float base;
    
    public Rectangulo(){
        this.altura = 0;
        this.base = 0;
    }
    
    public Rectangulo(float altura, float base){
        this.altura = altura;
        this.base = base;
    }
    
    public float getAltura(){
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    public float getBase(){
        return base;
    }
    public void setBase(float base) {
        this.base = base;
    }
    
    public float getArea(){
        return (base * altura);
    }
    
    public String toString(){
        return "Su altura es de " + altura + " y su base es de " + base;
    }
    
    public boolean isCuadrado(){
        return altura == base;
    }
    
    public void imprimirDatos1(){
        System.out.println("Figura número 1:");
        System.out.println(toString());
        if (isCuadrado() == true){
            System.out.println("como su base y su altura son iguales /nes un cuadrado");
        }else {
            System.out.println("Como su base y su altura son distintas /nes un rectangulo");
        }
        System.out.println("Su area es de "+getArea());
    }
    public void imprimirDatos2(){
        System.out.println("Figura número 2:");
        System.out.println(toString());
        if (isCuadrado() == true){
            System.out.println("como su base y su altura son iguales, es un cuadrado");
        }else {
            System.out.println("Como su base y su altura son distintas, es un rectangulo");
        }
        System.out.println("Su area es de "+getArea());
    }
}
