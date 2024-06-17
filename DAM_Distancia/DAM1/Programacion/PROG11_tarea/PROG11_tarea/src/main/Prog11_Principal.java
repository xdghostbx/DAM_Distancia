/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import com.prog11.bbdd.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author varov
 */
public class Prog11_Principal {

    /*static Scanner sc = new Scanner(System.in);

    public static void insertarVehiculos_Propietarios() {

    }

    public static void listarVehiculos() {

    }

    public static void actualizarPropietarioVehiculo() {

    }

    public static void listarVehiculosMarca() {

    }

    public static void eliminarVehiculo() {

    }

    public static void listarVehiculosPropietario() {

    }

    public static void eliminarPropietarioConVehiculo() {

    }

    public static void eliminarPropietarioSinvehiculo() {

    }*/
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         int tecla;
        System.out.println("Menú del concesionario, elige una opción:"
                + "1. Insertar vehículo"
                + "2. Listar vehículo"
                + "3. Actualizar propietario."
                + "4. Listar vehículos por marca."
                + "5. Eliminar vehículo."
                + "6. Listar vehículos de un propietario."
                + "7. Eliminar propietario con vehículo."
                + "8. Eliminar propietario sin vehículo.");
         */
        ConnectionDB conn = new ConnectionDB();
        Connection conexion = conn.openConnection();
        ArrayList<String> lista = null;

        int codError;

        //Ingresamos propietarios, si se realiza correctamente sale el mensaje de realizado con éxito.
         codError = PropietariosDAO.insertarPropietario(conexion, "Ana Isabel Sanchez Hermida", "12345678C");
        controlErrores(codError);
        codError = PropietariosDAO.insertarPropietario(conexion, "Celia Gutiérrez Hermida", "12345678D");
        controlErrores(codError);
        codError = PropietariosDAO.insertarPropietario(conexion, "Ángel Gutiérrez Sanchez", "12345678E");
        controlErrores(codError);
        codError = PropietariosDAO.insertarPropietario(conexion, "Iván González González", "12345678F");
        controlErrores(codError);
        codError = PropietariosDAO.insertarPropietario(conexion, "Iván González González", "12345679F");
        controlErrores(codError);

        //Ingresamos vehículos, si se realiza correctamente sale el mensaje de realizado con éxito.
        
        System.out.println("Insertamos los vehículos");
        codError = VehiculosDAO.insertarNuevoVehiculo(conexion, "1234abc", "mercedes",200 , (float) 399.4, "blanco", 2);
        controlErrores(codError);
        codError = VehiculosDAO.insertarNuevoVehiculo(conexion, "2223bbd", "renault",300 , (float) 19999.99, "gris", 4);
        controlErrores(codError);
        codError = VehiculosDAO.insertarNuevoVehiculo(conexion, "2244rts", "mercedes",20000 ,43000, "gris",2);
        controlErrores(codError);
        codError = VehiculosDAO.insertarNuevoVehiculo(conexion, "5430mdk", "bmw",199999 ,232131, "gris",1);
        controlErrores(codError);
        codError = VehiculosDAO.insertarNuevoVehiculo(conexion, "3214lf", "renault", 231314,3213124, "azul",3);
        controlErrores(codError);
        
        
        //listamos todos los vehículos
        lista = VehiculosDAO.recuperaVehiculos(conexion);
        for (String string : lista) {
            System.out.println(string);
        }

        System.out.println("Actualizamos el propietario del vehículo");
        codError = VehiculosDAO.actualizarPropietarioVehiculo(conexion, "1234abc", 3);
        controlErrores(codError);

        System.out.println("Listar vehículos");
        lista = VehiculosDAO.recuperaVehiculos(conexion);
        for (String string : lista) {
            System.out.println(string);
        }

        System.out.println("Vehículos por marca");
        lista = VehiculosDAO.recuperaVehiculoMarca(conexion, "renault");
        lista.forEach(System.out::println);

        System.out.println("Todos los vehículos de un propietario");

        lista = PropietariosDAO.recuVehiculo(conexion, "12345678E");
        lista.forEach(System.out::println);

        System.out.println("Eliminamos un propietario con vehículo");
        codError = PropietariosDAO.eliminarPropietario(conexion, "12345678E");
        controlErrores(codError);

        
        
        System.out.println("Eliminamos un propietario sin vehículo");
        codError = PropietariosDAO.eliminarPropietario(conexion, "12345679F");
        controlErrores(codError);
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
