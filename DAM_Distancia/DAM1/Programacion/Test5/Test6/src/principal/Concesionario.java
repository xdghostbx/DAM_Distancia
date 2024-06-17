/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package principal;

/**
 *
 * @author xdGHOSTbx
 */
public class Concesionario {
    private Vehiculo[] inventario; //tiene que tener el mismo nombre que la clase del objeto que lleva dentro
    private int indice;

    public Concesionario() {
        inventario = new Vehiculo [50];
        //this.inventario = new Vehiculo[50];
        this.indice = 0;
    }

public void agregarCoche(Vehiculo coche){
    if (indice < inventario.length){
        inventario[indice] = coche;
        indice++;
    }else
        System.out.println("Inventario lleno");
}    

public void mostrarInventario(){
    for (int i, inventario.lenght, i++ ){
    
    }
}
}
