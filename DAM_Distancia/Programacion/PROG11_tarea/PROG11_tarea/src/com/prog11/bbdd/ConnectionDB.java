/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prog11.bbdd;
import java.sql.*;

/**
 *
 * @author varov
 */
public class ConnectionDB {
    
    private final String driver = "org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mariadb://127.0.0.1:3306/Concesionario";
    private final String usuario = "root";
    private final String password = "admin";
    private Connection conexion = null;
    
    public Connection openConnection(){
        try {
            Class.forName(driver);
            conexion = (Connection)DriverManager.getConnection(url,usuario,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            
        }
        return conexion;
    }
    
    public void closeConnetion(){
       
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion: " + ex.getMessage());
        }
    }
}
