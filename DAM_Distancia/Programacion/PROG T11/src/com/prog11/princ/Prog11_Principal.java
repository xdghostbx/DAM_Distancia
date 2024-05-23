/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package com.prog11.princ;

import com.prog11.bbdd.PropietariosDAO;
import com.prog11.bbdd.ConnectionDB;
import com.prog11.bbdd.VehiculosDAO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author xdGHOSTbx
 */
public class Prog11_Principal {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    
        ConnectionDB conn = new ConnectionDB();
        Connection conexion = conn.abrirConexion();
        ArrayList<String> lista = null;

        int codError;
        //insertar propietarios, da error al darme un fallo en mwsql en el autoincremental para el id
        System.out.println("\nInsertar varios vehículos y propietarios");
        System.out.println("----------------------------------------");

        codError = PropietariosDAO.añadirPropietario(conexion, "Daniel Martinez Martinez", "11111111A");
        controlErrores(codError);
        codError = PropietariosDAO.añadirPropietario(conexion, "Sandra Veleiro Gonzalez", "11111111B");
        controlErrores(codError);
        
        codError = VehiculosDAO.añadirCoche(conexion, "1111AAA", "Seat", 1000, 1000, "Seat negro", 2);
        controlErrores(codError);
        codError = VehiculosDAO.añadirCoche(conexion, "1111BBB", "Dodge", 1000, 1000, "dodge con gris", 3);
        controlErrores(codError);
        
        // Listar todos los vehículos
        System.out.println("\nListar todos los vehículos ");
        System.out.println("-------------------------------------------");
        lista = VehiculosDAO.recuperaVehiculoDatos(conexion);
        lista.forEach(System.out::println);
        
        // Actualizar propietario de un vehículo.
        System.out.println("\nActualizar propietario de un vehículo");
        System.out.println("-------------------------------------");
        codError = VehiculosDAO.actualizarPropietario(conexion, "XYZ9876", 1);
        if (codError == 0) {
            System.out.println("\tOperación realiza con éxito!");
        } else if (codError == -1) {
            System.out.println("\t¡¡¡Error!!! El vehículo indicado no existe.");
        } else if (codError == -2) {
            System.out.println("\t¡¡¡Error!!! El propietario indicado no existe.");
        }
        
        // Listar todos los vehículos
        System.out.println("\nListar todos los vehículos ");
        System.out.println("-------------------------------------------");
        lista = VehiculosDAO.recuperaVehiculoDatos(conexion);
        lista.forEach(System.out::println);
        
        // Eliminar un vehículo que exista.
        System.out.println("\nEliminar un vehículo que exista");
        System.out.println("-------------------------------");
        codError = VehiculosDAO.eliminarCoche(conexion, "1111AAA");
        if (codError == 0) {
            System.out.println("\tOperación realiza con éxito!");
        } else if (codError == -1) {
            System.out.println("\t¡¡¡Error!!! El vehículo indicado no existe.");
        }
        
        // Eliminar un vehículo que no exista.
        System.out.println("\nEliminar un vehículo que no exista");
        System.out.println("----------------------------------");
        codError = VehiculosDAO.eliminarCoche(conexion, "111111");
        if (codError == 0) {
            System.out.println("\tOperación realiza con éxito!");
        } else if (codError == -1) {
            System.out.println("\t¡¡¡Error!!! El vehículo indicado no existe.");
        }
        
        // Listar todos los vehículos
        System.out.println("\nListar todos los vehículos ");
        System.out.println("-------------------------------------------");
        lista = VehiculosDAO.recuperaVehiculoDatos(conexion);
        lista.forEach(System.out::println);
        
        // Listar todos los vehículos de una marca
        System.out.println("\nListar todos los vehículos de una marca ");
        System.out.println("-------------------------------------------");
        lista = VehiculosDAO.recuperaVehiculoMarca(conexion,"Audi");
        lista.forEach(System.out::println);
        
        // Listar todos los vehículos de un propietario.
        System.out.println("\nListar todos los vehículos de un propietario");
        System.out.println("--------------------------------------------");
        lista = PropietariosDAO.recuperaVehiculo(conexion, "98765432B");
        lista.forEach(System.out::println);
        
        // Eliminar un propietario con vehículos.
        System.out.println("\nEliminar un propietario con vehículos");
        System.out.println("-------------------------------------");
        codError=PropietariosDAO.eliminarPropietario(conexion, "34567890F");
        System.out.println("Se han eliminado "+codError+" propietario/s de la base de datos.");
        
        // Eliminar un propietario sin vehículos.
        System.out.println("\nEliminar un propietario sin vehículos");
        System.out.println("-------------------------------------");
        codError = PropietariosDAO.eliminarPropietario(conexion, "11111111A");
        System.out.println("Se han eliminado " + codError + " propietarios de la base de datos.");
  }
  
  private static void controlErrores(int codError) {
        if (codError == 0) {
            System.out.println("\tOperación realiza con éxito!");
        } else if (codError == -1) {
            System.out.println("\t¡¡¡Error!!! Operación fallida.");
        } else if (codError == -2) {
            System.out.println("\t¡¡¡Error!!! El propietario indicado no existe.");
        }
    }
  
}
