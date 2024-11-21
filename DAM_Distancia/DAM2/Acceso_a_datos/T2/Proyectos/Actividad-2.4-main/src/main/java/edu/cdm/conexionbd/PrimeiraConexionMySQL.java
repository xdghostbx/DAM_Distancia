package edu.cdm.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrimeiraConexionMySQL {

     public static void main(String[] args) {
        try {
            // Establecemos la conexion con la BD
            //MySQL:  jdbc:mysql://host1:33060/db?key1=value1&key2=value2&key3=value3
            //Debería valer calquera das dúas posibles conexións: 
            // Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa",
            //  "root", "abc123.");

             Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?user=root&password=abc123.",
             "dani", "dani");
           
            System.out.println("Parabéns! Conecta correctamente con MySQL");
            conexion.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
    }
    
}