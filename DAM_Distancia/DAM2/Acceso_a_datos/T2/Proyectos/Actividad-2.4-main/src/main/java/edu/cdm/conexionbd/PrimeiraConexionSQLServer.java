package edu.cdm.conexionbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PrimeiraConexionSQLServer {

     public static void main(String[] args) {
        try {
            // Establecemos la conexion con la BD
            //SQL server: jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=empresa;user=user;password=abc123.;trustServerCertificate=true;");
            /* Se añade trustServerCertificate https://learn.microsoft.com/es-es/sql/connect/jdbc/setting-the-connection-properties?view=sql-server-ver16
             * para evitar excepción:  
             * com.microsoft.sqlserver.jdbc.SQLServerException: La propiedad "encrypt" está establecida en 
             * "true" y la propiedad "trustServerCertificate" está establecida en "false",
             *  pero el controlador no pudo establecer una conexión segura a SQL Server 
             * mediante el cifrado de Capa de sockets seguros (SSL):
             *  Error: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException:
             *  unable to find valid certification path to requested target. ClientConnectionId:1001144e-c427-4c44-a312-a090ef497b35
             */
            System.out.println("Parabéns! Conecta correctamente con SQL Server");
            conexion.close(); // Cerrar conexión
        } catch (SQLException cn) {
            cn.printStackTrace();
        }
    }
}