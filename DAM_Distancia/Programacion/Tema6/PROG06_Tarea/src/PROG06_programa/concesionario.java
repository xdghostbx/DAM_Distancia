/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG06_programa;

/**
 *
 * @author xdGHOSTbx
 */
public class concesionario {
    private vehiculo[] vehiculos;
    private int cantidadVehiculos;

    // Constructor
    public concesionario() {
        this.vehiculos = new vehiculo[50];
        this.cantidadVehiculos = 0;
    }

    // Método para buscar un vehículo por matrícula
    public String buscaVehiculo(String matricula) {
        for (int i = 0; i < cantidadVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                return vehiculos[i].toString();
            }
        }
        return null;
    }

    // Método para insertar un nuevo vehículo
    public int insertarVehiculo(vehiculo vehiculo) {
        if (cantidadVehiculos >= 50) {
            return -1; // Concesionario lleno
        }

        for (int i = 0; i < cantidadVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(vehiculo.getMatricula())) {
                return -2; // Matrícula duplicada
            }
        }

        vehiculos[cantidadVehiculos] = vehiculo;
        cantidadVehiculos++;
        return 0; // Inserción exitosa
    }

    // Método para listar los vehículos
    public void listaVehiculos() {
        if (cantidadVehiculos == 0) {
            System.out.println("El concesionario está vacío.");
            return;
        }

        System.out.println("Vehículos disponibles en el concesionario:");
        for (int i = 0; i < cantidadVehiculos; i++) {
            System.out.println(vehiculos[i].toString());
        }
    }

    // Método para actualizar los kilómetros de un vehículo
    public boolean actualizaKms(String matricula, int kms) {
        for (int i = 0; i < cantidadVehiculos; i++) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                vehiculos[i].setNumKilometros(kms);
                return true; // Actualización exitosa
            }
        }
        return false; // Matrícula no encontrada
    }
}
