/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog11.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author varov
 */
public class VehiculosDAO {

    public static int insertarNuevoVehiculo(Connection conexion, String matricula, String marca, int kms, float precio, String descripcion, int idProp) {
        int contador = 0;
        PreparedStatement sentencia = null;
        //verificamos que existen datos
        if (matricula == null || marca == null || kms < 0 || precio < 0 || descripcion == null || idProp < 0) {
            //comprobamos que el id del propietario exista
        } else if (!PropietariosDAO.existePropietario(conexion, idProp)) {
            contador = -1;
        } else {
            try {
                //ejecutamos la sentencia
                sentencia = conexion.prepareStatement("INSERT INTO vehiculos (mat_veh,marca_veh,kms_veh,precio_veh,desc_veh,id_prop) VALUES  (?,?,?,?,?,?)");
                //Introducimos valores
                sentencia.setString(1, matricula);
                sentencia.setString(2, marca);
                sentencia.setInt(3, kms);
                sentencia.setFloat(4, precio);
                sentencia.setString(5, descripcion);
                sentencia.setInt(6, idProp);
                //Ejecutamos el update
                sentencia.executeUpdate();
                contador = 0;
            } catch (SQLException ex) {
                System.out.println("No se ha podido acceder a la base: " + ex.getMessage());
                contador = -1;
            }
        }
        return contador;
    }

    /*Actualizar propietario de vehículo: Recibe por parámetro la matrícula de un vehículo junto 
al identificador de un propietario y trata de actualizar el vehículo en la BBDD. Devuelve 0 si la operación se realizó con éxito o -1 si el vehículo no existe.
     */
  public static int actualizarPropietarioVehiculo(Connection conexion, String matVeh, int idProp) {
        PreparedStatement sentencia = null;
        int codigo = -1;

        // Comprobar que el vehículo existe
        if (!VehiculosDAO.existeVehiculo(conexion, matVeh)) {
        } // Comprobar que el ID del propietario existe en el concesionario
        else if (!PropietariosDAO.existePropietario(conexion, idProp)) {
            codigo = -2;
        } else {
            try {
                // Preparar sensentia SQL
                sentencia = conexion.prepareStatement("UPDATE vehiculos SET id_prop = ? WHERE mat_veh = ?");
                // Incluir valores
                sentencia.setInt(1, idProp);
                sentencia.setString(2, matVeh);
                // Ejecutar sentencia
                sentencia.executeUpdate();
                codigo = 0;   // Devolvemos OK
            } catch (SQLException ex) {
                System.out.println("Error en la actualización de un propietario de un vehículo: " + ex.getMessage());
            }
        }
        return codigo;
    }

    public static int eliminarVehiculo(Connection conexion, String matricula) {
        int contador = 0;
        PreparedStatement sentencia = null;
        if (VehiculosDAO.existeVehiculo(conexion, matricula)) {
            try {
                sentencia = conexion.prepareStatement("DELETE FROM vehiculos WHERE mat_veh = ?");
                sentencia.setString(1, matricula);
                sentencia.executeUpdate();
                contador = 0;

            } catch (SQLException ex) {
                Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            contador = -1;
        }
        return contador;
    }

    public static ArrayList<String> recuperaVehiculoMarca(Connection conexion, String marca) {
        ArrayList<String> aux = new ArrayList();
        PreparedStatement sentencia = null;
        ResultSet respuesta = null;
        try {
            sentencia = conexion.prepareStatement("SELECT * FROM vehiculos WHERE marca_veh = ?");
            sentencia.setString(1, marca);
            respuesta = sentencia.executeQuery();
            while (respuesta.next()) {
                aux.add(respuesta.getString(1) + " " + respuesta.getString(2) + " " + respuesta.getInt(3) + " " + respuesta.getFloat(4) + " " + respuesta.getString(5));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;

    }

    public static ArrayList<String> recuperaVehiculos(Connection conexion) {
        PreparedStatement sentencia = null;
        ArrayList<String> aux = new ArrayList();
        ResultSet respuesta = null;
        try {
            sentencia = conexion.prepareStatement("SELECT * FROM vehiculos");
            respuesta = sentencia.executeQuery();
            while (respuesta.next()) {
                aux.add(respuesta.getString(1) + " " + respuesta.getString(2) + " " + respuesta.getInt(3) + " " + respuesta.getFloat(4) + " " + respuesta.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return aux;
        }

        return aux;

    }

    protected static boolean existeVehiculo(Connection conexion, String matricula) {
        Boolean existe = false;
        PreparedStatement sentencia = null;
        ResultSet respuesta = null;

        try {
            sentencia = conexion.prepareStatement("SELECT * FROM vehiculos where mat_veh = ?");
            sentencia.setString(1, matricula);
            respuesta = sentencia.executeQuery();
            existe = respuesta.next();

            return existe;

        } catch (SQLException ex) {
            Logger.getLogger(VehiculosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;

    }

}
