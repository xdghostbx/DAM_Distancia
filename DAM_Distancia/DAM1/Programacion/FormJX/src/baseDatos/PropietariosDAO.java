/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package baseDatos;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author xdGHOSTbx
 */
public class PropietariosDAO {
  public static int añadirPropietario(Connection conexion,String nombrePropietario, String dniPropietario){
      int codigo = -1;
      String consulta = "INSERT INTO propietarios(nombre_prop, dni_prop) VALUES(?,?)";
      try (PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, nombrePropietario);
        sql.setString(2, dniPropietario);
        sql.executeUpdate();
        codigo = 0;
      }catch(SQLException ex){
        System.out.println("Error al añadir propietario: "+ex.getMessage());
      }
      return codigo;
  }
  
  public static ArrayList<String> recuperaVehiculo (Connection conexion, String dniPropietario){
      String consulta = "SELECT mat_veh, marca_veh, kms_veh, precio_veh"
              + " FROM vehiculos v join propietarios p ON v.id_prop = p.id_prop"
              + " WHERE p.dni_prop = ?";
      ArrayList<String> lista = new ArrayList<>();
      try(
        PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1,dniPropietario);
        ResultSet resultSet = sql.executeQuery();
        while (resultSet.next()){
          lista.add(resultSet.getString("mat_veh")+resultSet.getString("marca_veh")+" "+resultSet.getString("kms_veh")+" "+resultSet.getFloat("precio_veh"));
        }
      }catch(SQLException ex){
        System.out.println("Error al consultar el propietario: "+ex.getMessage());
        lista = null;
      }
      
      return lista;
  }
  
  public static int eliminarPropietario(Connection conexion, String dniPropietario){
      String consulta ="DELETE FROM propietarios WHERE dni_prop = ?";
      int filasBorradas = 0;
      try(
        PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, dniPropietario);
        filasBorradas = sql.executeUpdate();
        
      }catch(SQLException ex){
        System.out.println("Error al borrar al propietario: "+ex.getMessage());
      }
      return filasBorradas;
  }
}
