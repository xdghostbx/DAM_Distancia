package edu.cdm.conexionbd.seccion5_8;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.cdm.conexionbd.properties.ConexionProperties;

public class ActualizaSentenciaPreparada {
    public static void main(String[] args) throws SQLException {
        try (// String urljdbc = "jdbc:oracle:thin:@localhost:1521:XE";
                Connection conexion = DriverManager.getConnection(
                        ConexionProperties.createUrlConnection("src/main/resources/db.sqlserver.properties"));
                PreparedStatement pstmt = conexion.prepareStatement("UPDATE EMP " + "SET SAL = ? WHERE empno = ?");) {
            // pstmt.setInt(1, 1);
            pstmt.setFloat(1, 3.5f);
            pstmt.setInt(2, 7844);
            pstmt.executeUpdate();

            // Con try with resources no es necesario cerrar los recursos de forma explícita
            // pstmt.close();
            // conexion.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
