/*
 * Clase para realizar la conexion con la base de datos
 */
package baseDatos; //pertenece al paquete donde se hace todo lo relacionado
import java.sql.*; //importamos el paquete de java.sql

/**
 *
 */
public class ConnectionDB {
    private final String driver = "com.mysql.cj.jdbc.Driver"; //driver
    private final String url = "jdbc:mysql://localhost:3307/Coches"; //nombre de la bbdd
    private final String usuario = "root"; //usr y psw
    private final String password = "root";
    
    public Connection conexion = null;
    //copiar todo esto para alante
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
