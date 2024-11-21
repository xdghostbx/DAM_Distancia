package edu.cdm.tarea02;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;
import edu.cdm.tarea02.model.util.exceptions.SaldoInsuficienteException;
import edu.cdm.tarea02.services.empleado.EmpleadoService;
import edu.cdm.tarea02.services.empleado.IEmpleadoServicio;

public class MenuTransferencia {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numeroEmpleadoOrigen = -1;
        int numeroEmpleadoDestino = -1;
        BigDecimal cantidadTransferir = new BigDecimal(0);
        boolean salir = false;

        System.out.println("Menú de Transferencia. Puede salir en cualquier momento introduciendo '0'.");

        // Solicitar número de empleado origen
        numeroEmpleadoOrigen = solicitarNumeroEmpleado(scanner, "origen");
        if (numeroEmpleadoOrigen == 0) {
            salir = true;
        }

        // Solicitar número de empleado destino si no se ha salido
        if (!salir) {
            numeroEmpleadoDestino = solicitarNumeroEmpleado(scanner, "destino");
            if (numeroEmpleadoDestino == 0) {
                salir = true;
            }
        }

        // Solicitar cantidad a transferir si no se ha salido
        while (!salir && (cantidadTransferir.compareTo(BigDecimal.ZERO) == 0)) {
            System.out.print("Introduzca la cantidad a transferir o '0' para salir: ");
            try {
                cantidadTransferir = scanner.nextBigDecimal();
                if (cantidadTransferir.compareTo(BigDecimal.ZERO) == 0) {
                    salir = true;
                    System.out.println("Saliendo del programa...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar una cantidad numérica válida.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        }

        // Realizar la transferencia si se han introducido todos los datos
        if (!salir) {
            System.out.println("\nRealizando transferencia...");

            try {
                IEmpleadoServicio empleadoServicio = new EmpleadoService();

                empleadoServicio.transferir(numeroEmpleadoOrigen, numeroEmpleadoDestino, cantidadTransferir);

                System.out.println("¡Enhorabuena! Se ha transferido con éxito. Consulte la base de datos.");
            } catch (UnsupportedOperationException e) {
                System.err.println("Ha ocurrido un error y no ha podido realizarse la operación");
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                System.err.println("No hay saldo suficiente y no ha podido realizarse la operación");
                e.printStackTrace();
            } catch (InstanceNotFoundException e) {
                System.err.println("No se ha localizado el movimiento de la transferencia.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("No se ha podido realizar la transferencia.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("No se ha podido crear el servicio EmpleadoService");
                e.printStackTrace();
            }

        } else {
            System.out.println("No se ha realizado ninguna transferencia.");
        }

        scanner.close();
    }

    /**
     * Solicita el número de empleado y permite salir introduciendo '0'.
     *
     * @param scanner Scanner para la entrada de datos.
     * @param tipo    Tipo de empleado ("origen" o "destino").
     * @return Número del empleado o '0' si se elige salir.
     */
    private static int solicitarNumeroEmpleado(Scanner scanner, String tipo) {
        int numeroEmpleado = -1;
        while (numeroEmpleado == -1) {
            System.out.print("Introduzca el número de empleado " + tipo + " o '0' para salir: ");
            try {
                numeroEmpleado = scanner.nextInt();
                if (numeroEmpleado == 0) {
                    System.out.println("Saliendo del programa...");
                    return 0; // Salida
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
                scanner.nextLine(); // Limpiar el buffer para evitar un bucle infinito
            }
        }
        return numeroEmpleado;
    }
}
