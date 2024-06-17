/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package principal;
import figuras.rectangulo;
import figuras.Circulo;
import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    private static rectangulo rectangulo1;
    private static Circulo circulo1;
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        rectangulo1 = new rectangulo();
        circulo1 = new Circulo();
        pedirDatos(entrada);
        rectangulo1.imprimirDatos();5
        circulo1.imprimirDatos();
        //System.out.println("El area del rectangulo es: " + rectangulo1.getArea());
    }
    
    private static void pedirDatos (Scanner entrada){
        System.out.println("Introduzca un valor para la base: ");
        float base = entrada.nextFloat();
        entrada.nextLine();
        
        System.out.println("Introduzca un valor para la altura: ");
        float altura = entrada.nextFloat();
        entrada.nextLine();
        
        rectangulo1.setBase(base);rectangulo1.setAltura(altura);
        
        System.out.println("Introduzca un valor para el radio: ");
        float radio = entrada.nextFloat();
        entrada.nextLine();
        
        circulo1.setRadio(radio);
        
        
    }
    
}
