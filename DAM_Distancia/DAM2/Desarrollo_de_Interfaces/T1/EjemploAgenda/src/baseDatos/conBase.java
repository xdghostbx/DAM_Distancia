/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package baseDatos;

import java.sql.*;
/**
 *
 * @author xdGHOSTbx
 */
public class conBase {
  private static Connection con;
  private static final String user="dani";
  private static final String pasw="3113";
  private static final String url="jdbc:mysql://localhost:3306/registro";
  
  public static void conector(){
    con = null;
    try {
        con = DriverManager.getConnection(url, user, pasw);
        System.out.println("Connection successful");
    } catch (SQLException e) {
        System.err.println("Error connecting to database: " + e.getMessage());
    }
  }
  
  public static Connection getConnection() {
        if (con == null) {
            conector();
        }
        return con;
    }
  
  public static void closeConnection(){
    if (con != null){
      try{
        con.close();
        System.out.println("Conexion cerrada");
      } catch (SQLException e){
        System.out.println("Error cerrando la conexion: "+e);
      }
    }
  }
}
