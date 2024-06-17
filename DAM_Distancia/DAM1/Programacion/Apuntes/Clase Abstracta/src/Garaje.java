
import java.util.ArrayList;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Garaje {
  Vehiculo[] Garaje;
  private int capacidad;
  private int contador;

  public Garaje(int capacidad) {
    this.capacidad = capacidad;
    this.Garaje = new Vehiculo[capacidad];
    this.contador = 0;
  }
  
   public void agregarVehiculo(Vehiculo v) {
        if (contador < capacidad) {
            Garaje[contador] = v;
            contador++;
            System.out.println("Vehículo agregado al garaje.");
        } else {
            System.out.println("El garaje está lleno. No se puede agregar más vehículos.");
        }
    }
  
  public void mostrarVehiculos() {
        for (int i = 0; i < Garaje.length; i++) {
            if (Garaje[i] != null) {
                System.out.println(Garaje[i].mostrarInfo());
            }
        }
    }
}
