package edu.cdm.conexionbd.seccion5_5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.cdm.conexionbd.properties.ConexionProperties;

public class PrimeraConsultaV2 {
    public static void main(String[] args) {

        //Usamos try-with-resources y nos ahorramos cerrar los recursos explicítamente
        //Leemos de un fichero los datos de conexión
        try (// Establecemos la conexion con la BD
                Connection conexion = DriverManager.getConnection(
                        ConexionProperties.createUrlConnection("src/main/resources/db.sqlserver.properties"));
                // creamos el objeto Statement
                Statement sentencia = conexion.createStatement();
                // ejecutamos la consulta

                ResultSet resul = sentencia.executeQuery("SELECT * FROM dept");) {
            // Recorremos el resultado para visualizar cada fila // Se hace un bucle
            // mientras haya registros y se van visualizando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }
         
        } catch (SQLException | IOException e) {
            
            e.printStackTrace();
        }

    }
}
