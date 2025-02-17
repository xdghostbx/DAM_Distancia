/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package circulo;

/**
 *
 * @author xdGHOSTbx
 */
public class circulo {
    private final double pi = 3.1415;
    private double radio;  
    
    //Constructor sin parametros
    public circulo() {
        this.radio = 0; 
    }

    //Constructor con un parámetro
    public circulo(double radio) {
        this.radio = radio;
    }
    
    //Set y Get
    public double getRadio(){
        return radio;
    }
    public void setRadio (double radio){
        if (radio > 0){
            this.radio = radio;
        } else{
            System.out.print("El radio debe ser mayor que 0");
        }
    }
    
    public double calcArea(){
        return pi *(radio*radio);
    }
    public double calcLongitud(){
        return 2*pi*radio;
    }
    public void proporcion(double prop){
        if (prop > 0){
            radio*=prop;
        }else {
            System.out.println("La proporcion debe ser mayor que 0");
        }
    }
    public void imprimirDatos(){
        System.out.println("Los datos son: ");
        System.out.println("Radio: "+radio);
        System.out.println("Area: "+calcArea());
        System.out.println("Longitud: "+calcLongitud());
    }
    
    public void pedirDatos(){
        System.out.println("Introduce el valor del radio: ");
    }
    //Datos con la proporción cambiada
    public void imprimirDatos2(){
        System.out.println("Los datos con la nueva proporcion son: ");
        System.out.println("Radio: "+radio);
        System.out.println("Area: "+calcArea());
        System.out.println("Longitud: "+calcLongitud());
    }
}