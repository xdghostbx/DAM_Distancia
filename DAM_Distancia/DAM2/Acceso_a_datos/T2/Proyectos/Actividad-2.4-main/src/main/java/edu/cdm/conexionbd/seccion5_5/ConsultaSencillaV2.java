package edu.cdm.conexionbd.seccion5_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaSencillaV2 {
    public static void main(String[] args) {

        // Usamos try-with-resources y nos ahorramos cerrar los recursos explicítamente
        try (// Cambio conexión Oracle por la de SQL Server
                Connection conexion = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;database=empresa;user=user;password=abc123.;trustServerCertificate=true;");
                Statement smt = conexion.createStatement();
                ResultSet rset = smt.executeQuery("select  empno, ename , job from emp order by 1");) {
            while (rset.next())
                System.out.println("empleado numero " + rset.getString(1) +
                        " nombre " + rset.getString(2) + " oficio " + rset.getString(3));

        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
}
