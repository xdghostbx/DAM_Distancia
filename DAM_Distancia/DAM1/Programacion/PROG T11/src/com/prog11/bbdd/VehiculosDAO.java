/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package com.prog11.bbdd;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author xdGHOSTbx
 */
public class VehiculosDAO {
  public static int añadirCoche(Connection conexion,String matricula, String marca, float kilometros, float precio, String descripcion, int id){
      int codigo = -1;
      String consulta = "INSERT INTO vehiculos (mat_veh,marca_veh,kms_veh,precio_veh,desc_veh,id_prop) VALUES  (?,?,?,?,?,?)";
      try (PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, matricula);
        sql.setString(2, marca);
        sql.setFloat(3, kilometros);
        sql.setFloat(4, precio);
        sql.setString(5, descripcion);
        sql.setInt(6, id);
        sql.executeUpdate();
        codigo = 0;
      }catch(SQLException ex){
        System.out.println("Error al añadir propietario: "+ex.getMessage());
        codigo = -1;
      }
      return codigo;
  }
  
  public static int actualizarPropietario(Connection conexion,String matricula, int id){
      int codigo = -1;
      String consulta = "UPDATE vehiculos SET id_prop = ? WHERE mat_veh = ?";
      try (PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setInt(1, id);
        sql.setString(2, matricula);
        sql.executeUpdate();
        codigo = 0;
      }catch(SQLException ex){
        System.out.println("Error al actualizar propietario: "+ex.getMessage());
        codigo = -1;
      }
      return codigo;
  }
  
  public static int eliminarCoche(Connection conexion, String matricula){
      int codigo;
      String consulta ="DELETE FROM vehiculos WHERE mat_veh = ?";
      int filasBorradas = 0;
      try(
        PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, matricula);
        sql.executeUpdate();
        codigo = 0;
        
      }catch(SQLException ex){
        System.out.println("Error al borrar al propietario: "+ex.getMessage());
        codigo = -1;
      }
      return codigo;
  }
  
  public static ArrayList<String> recuperaVehiculoMarca (Connection conexion, String marca){
      String consulta = "SELECT * FROM vehiculos WHERE marca_veh = ?";
      ArrayList<String> lista = new ArrayList<>();
      try(
        PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1,marca);
        ResultSet resultSet = sql.executeQuery();
        while (resultSet.next()){
          lista.add(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getFloat(3)+" "+resultSet.getFloat(4)+" "+resultSet.getString(5));
        }
      }catch(SQLException ex){
        System.out.println("Error al consultar el coche: "+ex.getMessage());
        lista = null;
      }
      
      return lista;
  }
  
  public static ArrayList<String> recuperaVehiculoDatos (Connection conexion){
      String consulta = "SELECT * FROM vehiculos";
      ArrayList<String> lista = new ArrayList<>();
      try(
        PreparedStatement sql = conexion.prepareStatement(consulta)){
        ResultSet resultSet = sql.executeQuery();
        while (resultSet.next()){
          lista.add(resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getFloat(3)+" "+resultSet.getFloat(4)+" "+resultSet.getString(5));
        }
      }catch(SQLException ex){
        System.out.println("Error al consultar el coche: "+ex.getMessage());
        lista = null;
      }
      
      return lista;
  }
}
