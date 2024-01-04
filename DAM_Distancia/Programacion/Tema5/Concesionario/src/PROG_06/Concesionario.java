/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG_06;

/**
 *
 * @author Dani
 */
public class Concesionario {
    private Vehiculo [] inventario;
    private int cantidadVehiculos;

    public Concesionario() {
        this.inventario = new Vehiculo [50];
        this.cantidadVehiculos = 0;
    }
    
    public int agregarVehiculo(Vehiculo vehiculo) {
        if (cantidadVehiculos == 50) {
            return -1; // Concesionario lleno, devuelve -1
        }

        for (int i = 0; i < cantidadVehiculos; i++) {
            if (inventario[i].getMatricula().equalsIgnoreCase(vehiculo.getMatricula())) {
                return -2; // Matrícula ya existe, devuelve -2
            }
        }

        inventario[cantidadVehiculos] = vehiculo;
        cantidadVehiculos++;
        return 0; // Vehículo agregado con éxito, devuelve 0
    }
    
    public void mostrarInventario() {
        System.out.println("Inventario de vehículos:");
        for (int i = 0; i < cantidadVehiculos; i++) {
            System.out.println("Vehículo " + (i + 1) + ":");
            System.out.print("Marca: " + inventario[i].getMarca()+", ");
            System.out.print("Matrícula: " + inventario[i].getMatricula()+", ");
            System.out.print("Precio: " + inventario[i].getPrecio()+"€, ");
            System.out.print("Kilometros: "+ inventario[i].getNumKilometros()+", ");
            System.out.println("Descripción: "+ inventario[i].getDescripcion()+" ");
            System.out.println(); 
        }
    }
    
    
    public Vehiculo buscarVehiculo(String buscaMatricula) {
        for (int j = 0; j < cantidadVehiculos; j++){
            if (inventario[j].getMatricula().equalsIgnoreCase(buscaMatricula)){
                return inventario[j];
            }
        }
        return null;
    }
    
    public boolean actualizaKMs(String buscaMatricula, int nuevosKilometros) {
        for (int z = 0; z < cantidadVehiculos; z++) {
            if (inventario[z].getMatricula().equalsIgnoreCase(buscaMatricula)) {
                if (nuevosKilometros >= 0) {
                    int totalKilometros = inventario[z].getNumKilometros() + nuevosKilometros;
                    inventario[z].setNumKilometros(totalKilometros);
                    return true; // Kilómetros actualizados con éxito, devuelve true
                } else {
                    return false; // Valor de kilómetros inválido, devuelve false
                }
            }
        }
        return false; // Vehículo no encontrado, devuelve false
    }
}
