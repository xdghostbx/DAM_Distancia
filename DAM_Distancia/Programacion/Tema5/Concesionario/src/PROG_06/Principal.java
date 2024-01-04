/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG_06;
import java.util.Scanner;
import javax.swing.*;
import Validaciones.Validaciones;

/**
 *
 * @author Dani
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
                    int resultado = nuevoCoche(entrada, concesionario);
                    if (resultado == 0) {
                        System.out.println("Vehículo agregado correctamente.");
                    } else if (resultado == -1) {
                        System.out.println("El inventario está lleno.");
                    } else if (resultado == -2) {
                        System.out.println("La matrícula ya existe en el concesionario.");
                    }
                    break;
                case 2:
                    concesionario.mostrarInventario();
                    break;
                case 3:
                    buscaMatricula(entrada, concesionario);
                    break;
                case 4:
                    actualizaKMs(entrada, concesionario);
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
    private static int nuevoCoche(Scanner entrada, Concesionario concesionario){
        String matricula, DNI, nombre, fechaMatriculacion;
        boolean matriculaValida = false;
        boolean nombreValido = false;
        boolean dniValido = false;
        boolean fechaValida = false;
        
        System.out.println("Introduzca la marca del vehiculo: ");
        String marca = entrada.nextLine();
        
        //validamos la matricula
        do {
            System.out.println("Introduzca la matricula:(0000AAA)");
            matricula = entrada.nextLine();
            matriculaValida = Validaciones.validarMatricula(matricula);
            if (!matriculaValida){
                System.out.println("Matricula no valida...");
            }
        }while(!matriculaValida);
        System.out.println("Introduzca el numero de kilomentros: ");
        int numKilometros = entrada.nextInt();
        entrada.nextLine();
       
        //validamos la fecha de matriculacion
        do {
            System.out.println("Introduzca la fecha de matriculacion: (dd/mm/aaa)");
            fechaMatriculacion = entrada.nextLine();
            fechaValida = Validaciones.validarFecha(fechaMatriculacion);
            if (!fechaValida){
                System.out.println("Fecha no valida...");
            }
        }while(!fechaValida);
        
        System.out.println("Introduzca la descripcion del vehiculo:");
        String descripcion = entrada.nextLine();
        System.out.println("Introduce el precio:");
        double precio = entrada.nextDouble();
        entrada.nextLine();
        
        //validamos el nombre
        do {
            System.out.println("Introduzca el nombre del propietario:");
            nombre = entrada.nextLine();
            nombreValido = Validaciones.validarNombre(nombre);
            if (!nombreValido){
                System.out.println("Nombre no valido...");
            }
        }while(!nombreValido);
        
        //validamos el DNI
        do {
            System.out.println("Introduzca el DNI:(00000000A)");
            DNI = entrada.nextLine();
            dniValido = Validaciones.validarDNI(DNI);
            if (!dniValido){
                System.out.println("DNI no valido...");
            }
        }while(!dniValido);
        
        
        Vehiculo vehiculo;
        vehiculo = new Vehiculo (marca, matricula, numKilometros,
                fechaMatriculacion, descripcion,
                precio, nombre, DNI);
        return concesionario.agregarVehiculo (vehiculo);
    }
    
    private static void buscaMatricula(Scanner entrada, Concesionario concesionario){
        String buscaMatricula;
        boolean matriculaValida;
        //validamos la matricula
        do {
             System.out.println("Introduzca la matricula:");
            buscaMatricula = entrada.nextLine();
            matriculaValida = Validaciones.validarMatricula(buscaMatricula);
            if (!matriculaValida){
                System.out.println("Matricula no valida...");
            }
        }while(!matriculaValida);
        
        
        Vehiculo coincide = concesionario.buscarVehiculo(buscaMatricula);
        if (coincide != null){
            System.out.println("Vechiculo encontrado: ");
            System.out.print("Marca: " + coincide.getMarca()+", ");
            System.out.print("Matricula: " + coincide.getMatricula()+", ");
            System.out.println("Precio: " + coincide.getPrecio()+"€");
            System.out.println();
        }else
            System.out.println("No existe vehiculo con esa matricula");
        
    }
    
    private static void actualizaKMs(Scanner entrada, Concesionario concesionario){
        String buscaMatricula;
        boolean matriculaValida;
        //validamos la matricula
        do {
             System.out.println("Introduzca la matricula:");
            buscaMatricula = entrada.nextLine();
            matriculaValida = Validaciones.validarMatricula(buscaMatricula);
            if (!matriculaValida){
                System.out.println("Matricula no valida...");
            }
        }while(!matriculaValida);
        
        
        Vehiculo coincide = concesionario.buscarVehiculo(buscaMatricula);
        if (coincide != null){
            System.out.println("Vechiculo encontrado: ");
            System.out.print("Marca: " + coincide.getMarca()+", ");
            System.out.print("Matricula: " + coincide.getMatricula()+", ");
            System.out.println("Kilometros: " + coincide.getNumKilometros());
            System.out.println("Introduzca la cantidad de kilómetros a sumar:");
            int nuevosKilometros = entrada.nextInt();
            entrada.nextLine(); // Limpiar el buffer
            // Validar que solo se puedan sumar kilómetros
            boolean actuOK = concesionario.actualizaKMs(buscaMatricula, nuevosKilometros);
            if (actuOK){
                System.out.println("Kilometros actualizados correctamente");
            } else {
                System.out.println("Error al actualizar los kilometros");
            }
        }else
            System.out.println("No existe vehiculo con esa matricula");
        
    }
}
