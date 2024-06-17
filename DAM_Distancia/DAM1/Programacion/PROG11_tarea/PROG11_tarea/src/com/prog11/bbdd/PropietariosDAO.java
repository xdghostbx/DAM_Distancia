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
public class PropietariosDAO {

    public static int insertarPropietario(Connection conexion, String nombreProp, String dniProp) {
        PreparedStatement sentencia = null;

        int codigo = -1;

        if (nombreProp == null || dniProp == null) {
            codigo = -1;
        } else {
            try {
                sentencia = conexion.prepareStatement("INSERT INTO propietarios(nombre_prop, dni_prop) VALUES(?,?)");
                sentencia.setString(1, nombreProp);
                sentencia.setString(2, dniProp);
                sentencia.executeUpdate();
                codigo = 0;
            } catch (SQLException ex) {
                System.out.println("No se ha podido insertar el propietario: " + ex.getMessage());
            }
        }

        return codigo;
    }

    public static ArrayList<String> recuVehiculo(Connection conexion, String dniProp) {
        ArrayList<String> aux = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement("SELECT v.mat_veh, v.marca_veh, v.kms_veh, v.precio_veh FROM vehiculos v JOIN propietarios p ON v.idProp = p.idProp where dni_prop = ?");
            sentencia.setString(1, dniProp);
            ResultSet respuesta = sentencia.executeQuery();
            while (respuesta.next()) {
                aux.add(respuesta.getString(1) + " " + respuesta.getString(2) + " " + respuesta.getInt(3) + " " + respuesta.getFloat(4));

            }
        } catch (SQLException ex) {
            System.out.println("Error en la recuperación de vehículos" + ex.getMessage());
            aux = null;
        }
        return aux;
    }

    public static int eliminarPropietario(Connection conexion, String dniProp) {
        PreparedStatement sentencia = null;
        int contador = 0;
        if (!PropietariosDAO.existedni(conexion, dniProp)) {

        }

        return contador;
    }

    protected static boolean existedni(Connection conexion, String dniProp) {
        PreparedStatement sentencia = null;
        ResultSet respuesta = null;
        Boolean existe = false;

        try {
            sentencia = conexion.prepareStatement("select * from propietario where dni_prop = ?");
            sentencia.setString(1, dniProp);
            respuesta = sentencia.executeQuery();
            existe = respuesta.next();

        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
    }

    protected static boolean existePropietario(Connection conexion, int idProp) {
        PreparedStatement sentencia = null;
        ResultSet respuesta = null;
        Boolean existe = false;
         try {
            sentencia = conexion.prepareStatement("select * from propietarios where id_prop = ?");
            sentencia.setInt(1, idProp);
            respuesta = sentencia.executeQuery();
            existe = respuesta.next();

        } catch (SQLException ex) {
            Logger.getLogger(PropietariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return existe;
        
    }
}
