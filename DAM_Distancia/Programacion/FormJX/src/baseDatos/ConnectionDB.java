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
public class ConnectionDB {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3307/Concesionario";
    private final String usuario = "root";
    private final String password = "root";
    
    public Connection conexion = null;
    
    public Connection abrirConexion() {
        try {
            Class.forName(driver);  //Carga el driver
            conexion = (Connection)DriverManager.getConnection(url, usuario, password);    //Realiza la conexión

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            conexion = null;
        }
        return conexion;
    }
    
    public void cerrarConexion() {
       if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
