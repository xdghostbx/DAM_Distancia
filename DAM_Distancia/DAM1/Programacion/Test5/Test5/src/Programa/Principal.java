/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Programa;

import java.util.Scanner;


public class Principal {

    private static Vehiculo coche;
    
    
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Introduce una de las opciones siguientes:\n"
                + "1.- Nuevo vehiculo\n2.-Ver matricula\n3.-Ver numero de kilometros\n"
                + "4.-Actualizar kilometros\n5.-Ver años de antigüedad\6.-Mostrar"
                + "propietario\n7.-Mostrar descripcion\n8.-Mostrar precio\n9.-"
                + "salir");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion){
            case 1:
                nuevoVehiculo(entrada);
                break;
            case 2:
                verMatricula();
                break;
            case 3:
                verKilometros();
                break;
            case 4:
                actualiarKilometros(entrada);
                break;
            case 5:
                System.out.println("pendiente de aplicar...");
                break;
            case 6:
                mostrarPropietario();
                break;
            case 7:
                mostrarDescripcion();
                break;
            case 8:
                mostrarPrecio();
                break;
            case 9:
                System.out.println("saliendo del programa...");
                break;
            default: 
                System.out.println("Introduce una opcion valida...");
                break;
        }
        }while(opcion != 9);
        
    }
    private static void nuevoVehiculo(Scanner entrada){
        System.out.println("Vamos a crear tu vehiculo: \n"
                + "Introduce su marca: ");
        String marca = entrada.nextLine();
        System.out.println("Introduce su matricula: ");
        String matricula = entrada.nextLine();
        System.out.println("Introduce el numero de kilometros: ");
        float numKilometros = entrada.nextFloat();
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
        
        /*Hueco para las validaciones, pero siguo con el codigo base*/
        coche = new Vehiculo(marca, matricula, numKilometros, fecha,descripcion, precio, nombre, DNI);
    }
    
    public static void verMatricula(){
        if (coche != null){
            System.out.println("Matricula: "+coche.getMatricula());
        }else
            System.out.println("No hay coche guardado en la base de datos");
    }
    
    public static void verKilometros(){
        if (coche != null){
            System.out.println("Kilometros totales: "+coche.getNumKilometros());
        }else
            System.out.println("No hay coche guardado en la base de datos");
    }
    
    public static void actualiarKilometros(Scanner entrada){
        if (coche != null){
            System.out.println("Introduce la cantidad de Kilometros a añadir: ");
            float newKMS = entrada.nextFloat();
            entrada.nextLine();
            if (newKMS > 0){
                coche.setNumKilometros(coche.getNumKilometros() + newKMS);
                System.out.println("Kilometros actualizados");
                System.out.println("La nueva cantidad de kilometros es de: "+coche.getNumKilometros());
            }else{
                System.out.println("La cantidad a añadir no puede ser negativa");
            }
            
        }else
            System.out.println("No hay coche guardado en la base de datos");
        
    }
    
    public static void verAntiguedad(){
    
    }
    
    public static void mostrarPropietario(){
        if (coche != null){
            System.out.println("Nombre del propietario: "+coche.getNombrePropietario());
        }else
            System.out.println("No hay coche guardado en la base de datos");
    }
    
    public static void mostrarDescripcion(){
        if (coche != null){
            System.out.println("Descripcion de coche: "+coche.getDescripcion());
        }else
            System.out.println("No hay coche guardado en la base de datos");
    }
    
    public static void mostrarPrecio(){
        if (coche != null){
            System.out.println("Precio: "+coche.getPrecio());
        }else
            System.out.println("No hay coche guardado en la base de datos");
    }
    
}
