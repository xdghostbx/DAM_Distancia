/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG06_programa;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        concesionario concesionario = new concesionario();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Nuevo Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Buscar Vehículo");
            System.out.println("4. Modificar kms Vehículo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Introduzca la marca del vehículo:");
                    String marca = scanner.nextLine();

                    System.out.println("Introduzca la matrícula del vehículo:");
                    String matricula = scanner.nextLine();

                    System.out.println("Introduzca el número de kilómetros del vehículo:");
                    int numKilometros = scanner.nextInt();
                    scanner.nextLine();// Limpiar el buffer

                    System.out.println("Introduzca la fecha de matriculación (yyyy-MM-dd):");
                    String fechaMatriculacionString = scanner.nextLine();
                    LocalDate fechaMatriculacion = LocalDate.parse(fechaMatriculacionString);

                    System.out.println("Introduzca la descripción del vehículo:");
                    String descripcion = scanner.nextLine();

                    System.out.println("Introduzca el precio del vehículo:");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.println("Introduzca el nombre del propietario:");
                    String nombrePropietario = scanner.nextLine();

                    System.out.println("Introduzca los numeros del DNI del propietario:");
                    int dniPropietario = scanner.nextInt();
                    scanner.nextLine();

                    vehiculo vehiculo = new vehiculo(marca, matricula, numKilometros,
                                        fechaMatriculacion, descripcion, precio,
                                        nombrePropietario, dniPropietario);
                    int resultado = concesionario.insertarVehiculo(vehiculo);
                    if (resultado == 0) {
                        System.out.println("Vehículo agregado con éxito al concesionario.");
                    } else if (resultado == -1) {
                        System.out.println("El concesionario está lleno. No se pudo agregar el vehículo.");
                    } else if (resultado == -2) {
                        System.out.println("Ya existe un vehículo con esa matrícula en el concesionario.");
                    }
                    break;
                case 2:
                    concesionario.listaVehiculos();
                    break;
                case 3:
                    System.out.print("Ingrese la matrícula del vehículo a buscar: ");
                    String matriculaBuscar = scanner.nextLine();
                    String datosVehiculo = concesionario.buscaVehiculo(matriculaBuscar);
                    if (datosVehiculo != null) {
                        System.out.println("Datos del vehículo:\n" + datosVehiculo);
                    } else {
                        System.out.println("No existe vehículo con la matrícula introducida.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la matrícula del vehículo a modificar: ");
                    String matriculaModificar = scanner.nextLine();
                    System.out.print("Ingrese los nuevos kilómetros: ");
                    int nuevosKilometros = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    boolean actualizacionExitosa = concesionario.actualizaKms(matriculaModificar, nuevosKilometros);
                    if (actualizacionExitosa) {
                        System.out.println("Kilómetros actualizados con éxito.");
                    } else {
                        System.out.println("No se pudo actualizar. Vehículo no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 5);
    }
    
    
}