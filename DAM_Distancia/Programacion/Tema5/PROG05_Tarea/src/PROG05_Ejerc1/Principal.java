/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG05_Ejerc1;

import java.time.LocalDate;
import java.util.Scanner;
import PROG05_Ejerc1_util.Validaciones;

public class Principal {
    private static Vehiculo vehiculo; // Referencia al vehículo

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            Menu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    NuevoVehiculo(scanner);
                    break;
                case 2:
                    Matricula();
                    break;
                case 3:
                    NumKilometros();
                    break;
                case 4:
                    actualizarKilometros(scanner);
                    break;
                case 5:
                    AnhosAntiguedad();
                    break;
                case 6:
                    Propietario();
                    break;
                case 7:
                    Descripcion();
                    break;
                case 8:
                    Precio();
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Introduce una opción  válida.");
            }
        } while (opcion != 9);
    }

    private static void Menu() {
        System.out.println("Seleccione una opción de la lista siguiente:");
        System.out.println("1. Nuevo Vehículo");
        System.out.println("2. Ver Matrícula");
        System.out.println("3. Ver Número de Kilómetros");
        System.out.println("4. Actualizar Kilómetros");
        System.out.println("5. Ver años de antigüedad");
        System.out.println("6. Mostrar propietario");
        System.out.println("7. Mostrar Descripción");
        System.out.println("8. Mostrar Precio");
        System.out.println("9. Salir");
    }

    private static void NuevoVehiculo(Scanner scanner) {
        System.out.println("Introduzca la marca del vehículo:");
        String marca = scanner.nextLine();

        System.out.println("Introduzca la matrícula del vehículo:");
        String matricula = scanner.nextLine();

        System.out.println("Introduzca el número de kilómetros del vehículo:");
        int numKilometros = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

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

        System.out.println("Introduzca el DNI del propietario:");
        String dniPropietario = scanner.nextLine();
        
        if (Validaciones.validarDNI(dniPropietario) && 
                Validaciones.validarFecha(fechaMatriculacion) &&
                Validaciones.validarKilometros(numKilometros)){
            vehiculo = new Vehiculo(marca, matricula, numKilometros, fechaMatriculacion,
                                    descripcion, precio, nombrePropietario, dniPropietario);
        } else {
            System.out.println("Error en los datos. No se pudo crear el vehículo.");
        }
        // Aquí debes realizar las validaciones según lo requerido en el enunciado
        // y crear una instancia de la clase Vehiculo si los datos son válidos

        // Ejemplo: realizar validaciones y crear el vehículo si los datos son válidos
        // if (validarDatos(...)) {
        //     vehiculo = new Vehiculo(marca, matricula, numKilometros, fechaMatriculacion,
        //                             descripcion, precio, nombrePropietario, dniPropietario);
        // } else {
        //     System.out.println("Error en los datos. No se pudo crear el vehículo.");
        // }
    }

    private static void Matricula() {
        if (vehiculo != null) {
            System.out.println("Matrícula: " + vehiculo.getMatricula());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void NumKilometros() {
        if (vehiculo != null) {
            System.out.println("Número de Kilómetros: " + vehiculo.getNumKilometros());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void actualizarKilometros(Scanner scanner) {
        if (vehiculo != null) {
            System.out.println("Introduzca la cantidad de kilómetros a sumar:");
            int nuevosKilometros = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            // Validar que solo se puedan sumar kilómetros
            if (nuevosKilometros > 0) {
                int totalKilometros = vehiculo.getNumKilometros() + nuevosKilometros;
                vehiculo.setNumKilometros(totalKilometros);
                System.out.println("Kilómetros actualizados.");
                System.out.println("El nuevo numero de Kilometros es de: "
                                    + vehiculo.getNumKilometros());
            } else {
                System.out.println("Error: Debe ingresar una cantidad válida de kilómetros.");
            }
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void AnhosAntiguedad() {
        if (vehiculo != null) {
            System.out.println("Años de antigüedad: " + vehiculo.get_Anhos());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void Propietario() {
        if (vehiculo != null) {
            System.out.println("Propietario: " + vehiculo.getNombrePropietario() +
                               ", DNI: " + vehiculo.getDniPropietario());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void Descripcion() {
        if (vehiculo != null) {
            System.out.println("Descripción: " + vehiculo.getDescripcion() +
                               ", Matrícula: " + vehiculo.getMatricula() +
                               ", Kilómetros: " + vehiculo.getNumKilometros());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void Precio() {
        if (vehiculo != null) {
            System.out.println("Precio: " + vehiculo.getPrecio());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

}