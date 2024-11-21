package edu.cdm.conexionbd.seccion5_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActualizacionEliminacion {

    public static void main(String[] args) {
        // establecemos la conexion

        try {
            Connection conexion = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;database=empresa;user=user;password=abc123.;trustServerCertificate=true;");
            // crea la sentencia
            Statement stm = conexion.createStatement();
            // Se han cambiado las tablas para trabajar con la BD empresa

          mostrarDepts(conexion);

            // ejecuta el borrado, la ejecucion devuelve 19, numero de filas afectadas
            System.out.println("Se han eliminado " + stm.executeUpdate("delete from dept where DNAME = 'IT' ") + " registros");

            mostrarDepts(conexion);

            stm.close(); // Cerrar Statement
                         // cierra la conexion
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void mostrarDepts(Connection conexion) {
        try (// Vemos los departamentos actuales:
             // creamos el objeto Statement
                Statement sentencia = conexion.createStatement();
                ResultSet resul = sentencia.executeQuery("SELECT * FROM dept");) {

            // Recorremos el resultado para visualizar cada fila // Se hace un bucle
            // mientras haya registros y se van visualizando
            while (resul.next()) {
                System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }
}
