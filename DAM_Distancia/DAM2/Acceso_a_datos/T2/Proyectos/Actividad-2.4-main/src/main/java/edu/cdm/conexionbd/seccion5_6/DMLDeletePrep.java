package edu.cdm.conexionbd.seccion5_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DMLDeletePrep {
    public static void main(String[] args) {
        try {
            // Establecemos la conexion con la BD
            // SQL server:
            // jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=empresa;user=user;password=abc123.;trustServerCertificate=true;");
         
            String deptno = args[0];
            String sql = "DELETE FROM dept WHERE DEPTNO=?";
            System.out.println(sql);
            PreparedStatement sentencia = conexion.prepareStatement(sql);



           

            sentencia.setInt(1, Integer.parseInt(deptno));
            int filas = sentencia.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
            sentencia.close();
            // Cerrar conexion
            conexion.close();
        }
       catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
