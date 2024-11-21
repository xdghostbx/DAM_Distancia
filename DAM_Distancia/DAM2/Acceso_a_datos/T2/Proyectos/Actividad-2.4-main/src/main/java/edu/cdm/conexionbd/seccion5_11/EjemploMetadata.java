package edu.cdm.conexionbd.seccion5_11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.cdm.conexionbd.properties.ConexionProperties;

public class EjemploMetadata {
    public static void main(String[] args) {

        try (// Connection conexion =
             // DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo",
             // "ejemplo");
                Connection conexion = DriverManager.getConnection(
                        ConexionProperties.createUrlConnection("src/main/resources/db.sqlserver.properties"))) {
            java.sql.DatabaseMetaData dbmd = conexion.getMetaData();// Creamos objeto DatabaseMetaData
         
            ResultSet resul = null;
            String nombre = dbmd.getDatabaseProductName();
            String driver = dbmd.getDriverName();
            String url = dbmd.getURL();
            String usuario = dbmd.getUserName();

            System.out.println("INFORMACIÓN SOBRE LA BASE DE DATOS:");
            System.out.printf("Nombre : %s %n", nombre);
            System.out.printf("Driver : %s %n", driver);
            System.out.printf("URL    : %s %n", url);
            System.out.printf("Usuario: %s %n", usuario);


            // Obtener información de las tablas y vistas que hay
            resul = dbmd.getTables("empresa", null, null, null);
            while (resul.next()) {
                String catalogo = resul.getString(1);// columna 1
                String esquema = resul.getString(2); // columna 2
                String tabla = resul.getString(3); // columna 3
                String tipo = resul.getString(4); // columna 4
                System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
            }
        
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException  e) {
             System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
        }
    }

}
