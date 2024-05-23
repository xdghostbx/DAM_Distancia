/*
 este es el metodo main
 */
package pruebas;

import java.util.Scanner;
import static pruebas.metodos.getArea;
import static pruebas.metodos.isCuadrado;

/**
 *
 * @author xdGHOSTbx
 */
public class pruebas {
    private static rectangulo rect;
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float base,altura;
        System.out.println("Introduce un valor para la base: ");
        base = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Introduce un valor para la altura: ");
        altura = entrada.nextInt();
        entrada.nextLine();
        rect = new rectangulo (base, altura);
        imprimirDatos1();
    }
        
    public static void imprimirDatos1(){
        System.out.println("Su altura es de " + rect.getAltura() + " y su base es de " + rect.getBase());
        if (isCuadrado(rect.getBase(), rect.getAltura()) == true){
            System.out.println("como su base y su altura son iguales \nes un cuadrado");
        }else {
            System.out.println("Como su base y su altura son distintas \nes un rectangulo");
        }
        System.out.println("Su area es de "+ getArea(rect.getBase(), rect.getAltura()));
    }
}

    

