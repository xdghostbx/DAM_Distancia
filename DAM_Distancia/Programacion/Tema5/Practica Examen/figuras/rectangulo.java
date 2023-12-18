/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package figuras;

/**
 *
 * @author xdGHOSTbx
 */
public class rectangulo {
    private float base;
    private float altura;
    
    public rectangulo() {
        base = 0;
        altura = 0;
    }
    
    public rectangulo(float base, float altura) {
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public float getArea(){
        return (base * altura);
    }
    
    public String toString(){
        return("Su base es: " + base + "y su altura es: "+ altura);
    }
    
    public boolean isCuadrado(){
        return base==altura;
    }
    
    public void imprimirDatos(){
        System.out.println("Figura número 1:");
        System.out.println(toString());
        if (isCuadrado() == true){
            System.out.println("como su base y su altura son iguales, es un cuadrado");
        }else {
            System.out.println("Como su base y su altura son distintas, es un rectangulo");
        }
        System.out.println("Su area es de "+getArea());
    }
}
