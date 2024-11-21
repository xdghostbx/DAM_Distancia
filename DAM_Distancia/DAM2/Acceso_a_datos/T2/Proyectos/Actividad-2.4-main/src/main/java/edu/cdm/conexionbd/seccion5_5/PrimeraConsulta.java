package edu.cdm.conexionbd.seccion5_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrimeraConsulta {
    public static void main(String[] args) {
        try {
            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?user=root&password=abc123.",
             "root", "abc123.");
            // creamos el objeto Statement
            Statement sentencia = conexion.createStatement();
            // ejecutamos la consulta
            String sql = "SELECT * FROM dept";
            ResultSet resul = sentencia.executeQuery(sql);
            // Recorremos el resultado para visualizar cada fila // Se hace un bucle
            // mientras haya registros y se van visualizando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }
            resul.close(); // Cerrar ResultSet
            sentencia.close(); // Cerrar Statement
            conexion.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
    }
}
