/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package figuras;
import java.lang.Math;
/**
 *
 * @author xdGHOSTbx
 */
public class Circulo {
    private float radio;

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }
    
    public Circulo() {
        radio= 0;
    }
    
    public Circulo(float radio) {
        this.radio = radio;
    }
    
    public float getArea(){
        return (float)(Math.PI * Math.pow(radio, 2));
    }
    public void imprimirDatos(){
        System.out.println("Figura número 1:");
        
            System.out.println("Su figura es un circulo de radio: "+ radio);
        
        System.out.println("Su area es de "+getArea());
    }
    
}
