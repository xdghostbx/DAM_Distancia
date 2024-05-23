/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package principal;

import java.util.Scanner;

/**
 *
 * @author xdGHOSTbx
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Concesionario concesionario = new Concesionario();
        int opcion = 0;
        do{
            System.out.println("MENU CONCESIONARIO");
            System.out.println("Introduce una de las siguientes opciones");
            System.out.println("1.- Agregar nuevo vehiculo");
            System.out.println("2.- Ver vehiculos listados");
            System.out.println("3.- Buscar vehiculo");
            System.out.println("4.- Modificar KM Vehiculo");
            System.out.println("5.- Salir del programa");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion){
                case 1:
                    
                    break;
                case 2:
                    //concesionario.mostrarInventario();
                    break;
                case 3:
                    //buscaMatricula(entrada, concesionario);
                    break;
                case 4:
                    //actualizaKMs(entrada, concesionario);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;   
                default:
                    System.out.println("Introduce una opcion correcta...");
                    break;
            }
        }while (opcion != 5);
    }
    
    public static void agregarCoche(Scanner entrada, Concesionario concesionario){
        System.out.println("Vamos a crear tu vehiculo: \n"
                + "Introduce su marca: ");
        String marca = entrada.nextLine();
        System.out.println("Introduce su matricula: ");
        String matricula = entrada.nextLine();
        System.out.println("Introduce el numero de kilometros: ");
        float kilometros = entrada.nextFloat();
        entrada.nextLine();
        System.out.println("Introduce la fecha de matriculacion (dd/mm/aaaa): ");
        String fecha = entrada.nextLine();
        System.out.println("Introduce una descripcion de coche: ");
        String descripcion = entrada.nextLine();
        System.out.println("Introduce un precio de venta: ");
        float precio = entrada.nextFloat();
        entrada.nextLine();
        System.out.println("Introduce el nombre completo del propietario: ");
        String nombre = entrada.nextLine();
        System.out.println("Introduce el dni del propietario: ");
        String DNI = entrada.nextLine();
        
        Vehiculo coche;
        coche = new Vehiculo (marca, matricula, kilometros, fecha, descripcion, precio, nombre, DNI);
        concesionario.agregarCoche(coche);
    }
    
    public static void mostrarInventario(){
        
    }
}
