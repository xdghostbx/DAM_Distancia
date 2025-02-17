
import java.sql.Connection;
import java.sql.*;
/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class ConsultaBase {

  /**
   *  1. Mostrar y pedir información de la base de datos en general.
      2. Mostrar la información de la tabla pasajeros.
      3. Ver la información de los pasajeros de un vuelo, pasando el código de vuelo como parámetro.
      4. Insertar un vuelo cuyos valores se pasan como parámetros.
      5. Borrar el vuelo que se metió anteriormente en el que se pasa por parámetro su número de vuelo.
      6. Modificar los vuelos de fumadores a no fumadores.
   */
  public static void main(String[] args) {
    consultaVuelo();
  }
  
    private static final String driver = "org.mariadb.jdbc.Driver";
    private static final String url = "jdbc:mariadb://localhost:3306/aerolinea";
    private static final String usuario = "root";
    private static final String password = "root";
    
    private static  Connection conexion = null;
    
    /**
     * Metodo para iniciar la conexion a la base de datos
    * @return conexion a la base de datos
     */
    public static Connection abrirConexion() {
        try {
            Class.forName(driver);  //Carga el driver
            conexion = DriverManager.getConnection(url, usuario, password);    //Realiza la conexión

        } catch (ClassNotFoundException ex) {
            System.out.println("Error cargando el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.getMessage());
            conexion = null;
        }
        return conexion;
    }

    /**
     * Metodo para finalizar la conexion a la base de datos
     */
    public static void cerrarConexion() {
       if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    public static void consultaVuelo(){
      abrirConexion();
      String consulta = "SELECT * FROM vuelos ";
      try(PreparedStatement sql = conexion.prepareStatement(consulta)){
        ResultSet a = sql.executeQuery();
        while(a.next()){
          System.out.println(a.getString("cod_vuelo") + "  " + a.getString("hora_salida") + " " + a.getString("destino")+ "  "  + a.getString("procedencia")+ "  " + a.getInt("plazas_fumador")
          + "  " + a.getInt("plazas_no_fumador")+ "  " + a.getInt("Plazas_turista")+ "  " + a.getInt("Plazas_primera"));
        }
      }catch(SQLException ex){
        System.out.println("Error al listar alumnos: "+ex.getMessage());
      }finally{
        cerrarConexion();
      }
    }
  
}
