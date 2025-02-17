/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package PROG_06;

/**
 *
 * @author Daniel Martinez
 * 
 * clase concesionario, donde creo el objeto concesionario para llamarlo mas adelante
 * tambien se crea el array para guardar los 50 vehiculos y distintos metodos
 * para llamarlos desde el programa principal
 */
public class Concesionario {
    private Vehiculo [] inventario;
    private int cantidadVehiculos;

    public Concesionario() {
        this.inventario = new Vehiculo [50];
        this.cantidadVehiculos = 0;
    }
    /*
        metodo para agregar nuevos coches, si está lleno, devuelve -1
        si el coche es repetido, devuelve -2
        si el coche se agrega con exito, devuelve 0
    */
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
    //metodo para mostrar todo el inventario guardado
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
    
    /*
        metodo para buscar una matricula, devuelve el inventario en la posicion
        de donde encontro la matricuka
    */
    public Vehiculo buscarVehiculo(String buscaMatricula) {
        for (int j = 0; j < cantidadVehiculos; j++){
            if (inventario[j].getMatricula().equalsIgnoreCase(buscaMatricula)){
                return inventario[j];
            }
        }
        return null;
    }
    /*
        metodo para actualizar los kilometros siempre que el numero de 
        kilometros sea superior a 0 y encuentre la matricula
    */
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
