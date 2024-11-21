package edu.cdm.conexionbd.seccion5_7_1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JJBH
 */
public class inserConProcAlma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Cargar el driver de mysql
           // Class.forName("com.mysql.jdbc.Driver");

            // Cadena de conexión para conectar con MySQL en localhost,
            //seleccionar la base de datos llamada ‘test’
            // con usuario y contraseña del servidor de MySQL: root y admin
            String connectionUrl = "jdbc:mysql://localhost/test?" +
                                   "user=root&password=abc123.";
            // Obtener la conexión
            Connection con = DriverManager.getConnection(connectionUrl);

            // El procedimiento almacenado tendrá tres parámetros
            CallableStatement prcProcedimientoAlmacenado =
                    con.prepareCall("{ call insertaCliente(?, ?,?) }");

            // cargar parametros en el procedimiento almacenado
	    prcProcedimientoAlmacenado.setInt("Cod_Cliente", 765);
            prcProcedimientoAlmacenado.setString("Nombre", "Antonio Pérez") ;
            prcProcedimientoAlmacenado.setString("Telefono", "950121314") ;
	
            // ejecutar el procedimiento
	    prcProcedimientoAlmacenado.execute();
	
       } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
       }

    }


}
