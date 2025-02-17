/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 *
 * Autor: Daniel Martínez
 * Esta es la clase principa
 * Consta de un menu con el que el usuario puede realizar diferentes opciones
 * 1. Introducir datos nuevos de un vechiculo
 * 2. Ver la matricula del vechiculo introducido
 * 3. Ver Número de Kilómetros
 * 4. Actualizar el numero de Kilómetros
 * 5. Ver años de antigüedad
 * 6. Mostrar nombre y dni del propietario
 * 7. Mostrar Descripción del vehiculo, matricula y kilometros
 * 8. Mostrar Precio del vehiculo
 * 9. Salir del programa
 * Para cada una de las opciones de este menu se llama a su metodo correspondiente
 * que realiza la accion indicada en el propio menu
 */
package PROG05_Ejerc1;

import java.time.LocalDate; //importamos libreria java para trabajar con fechas
import java.util.Scanner; //importamos libreria java para pedir datos al usuario
import PROG05_Ejerc1_util.Validaciones; //importamos el paquete donde tengo las validaciones

public class Principal {
    private static Vehiculo vehiculo; // Referencia a los datos del vehículo

    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        int opcion;
        /*
        Creo un menu con un do-while para que se mantenga en el. Las opciones
        son las dadas en el ejercicio.
        */
        do {
            Menu(); //llamo al metodo menu
            opcion = datos.nextInt(); /*creo un integer opcion para seleccionar
                                        cada una de las opciones*/
            datos.nextLine(); // Limpiar el buffer del scanner
            
            //Un menu con switch-case 
            switch (opcion) {
                case 1:
                    NuevoVehiculo(datos);
                    break;
                case 2:
                    Matricula();
                    break;
                case 3:
                    NumKilometros();
                    break;
                case 4:
                    actualizarKilometros(datos);
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
        } while (opcion != 9); /*finalizar el while con la opcion que sale del menu 
                               y rompe el bucle*/
    }
    //Metodo menu, imprimer el menu
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
    //Metodo NuevoVehiculo, para introducir los datos del coche
    private static void NuevoVehiculo(Scanner datos) {
        System.out.println("Introduzca la marca del vehículo:");
        String marca = datos.nextLine();

        System.out.println("Introduzca la matrícula del vehículo:");
        String matricula = datos.nextLine();

        System.out.println("Introduzca el número de kilómetros del vehículo:");
        int numKilometros = datos.nextInt();
        datos.nextLine();// Limpiar el buffer

        System.out.println("Introduzca la fecha de matriculación (yyyy-MM-dd):");
        String fechaMatriculacionString = datos.nextLine();
        LocalDate fechaMatriculacion = LocalDate.parse(fechaMatriculacionString);

        System.out.println("Introduzca la descripción del vehículo:");
        String descripcion = datos.nextLine();

        System.out.println("Introduzca el precio del vehículo:");
        double precio = datos.nextDouble();
        datos.nextLine(); // Limpiar el buffer

        System.out.println("Introduzca el nombre del propietario:");
        String nombrePropietario = datos.nextLine();

        System.out.println("Introduzca los numeros del DNI del propietario:");
        int dniPropietario = datos.nextInt();
        datos.nextLine();
        
        if (Validaciones.validarDNI(dniPropietario) && 
                Validaciones.validarFecha(fechaMatriculacion) &&
                Validaciones.validarKilometros(numKilometros)){
            vehiculo = new Vehiculo(marca, matricula, numKilometros, fechaMatriculacion,
                                    descripcion, precio, nombrePropietario, dniPropietario);
        } else {
            System.out.println("Error en los datos. No se pudo crear el vehículo.");
        }
    }
    //Metodo para imprimir la matricula, si no hay vehiculo, devuelve el mensaje de error
    private static void Matricula() {
        if (vehiculo != null) {
            System.out.println("Matrícula: " + vehiculo.getMatricula());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }
    //Metodo para imprimir el num de Kilometros, si no hay coche devuelve mensaje de error
    private static void NumKilometros() {
        if (vehiculo != null) {
            System.out.println("Número de Kilómetros: " + vehiculo.getNumKilometros());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }
    //Metodo para actualizar los kilometros
    private static void actualizarKilometros(Scanner datos) {
        if (vehiculo != null) {
            System.out.println("Introduzca la cantidad de kilómetros a sumar:");
            int nuevosKilometros = datos.nextInt();
            datos.nextLine(); // Limpiar el buffer

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
    
    //metodo que devuelve los años de matriculacion del vehiculo
    private static void AnhosAntiguedad() {
        if (vehiculo != null) {
            System.out.println("Años de antigüedad: " + vehiculo.get_Anhos());
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

    private static void Propietario() {
        if (vehiculo != null) {
            String dniCompleto = Validaciones.algoritmoDNI(vehiculo.getDniPropietario());
            System.out.println("Propietario: " + vehiculo.getNombrePropietario() +
                               ", DNI: " + dniCompleto);
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
            System.out.println("Precio: " + vehiculo.getPrecio()+"euros");
        } else {
            System.out.println("No hay ningún vehículo registrado.");
        }
    }

}