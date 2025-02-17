

package baseDatosAModelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    //establecer conexion con la BD
    String url = "jdbc:sqlserver://localhost:1433;databaseName=empresa";
    String user = "dani";
    String password = "dani";
    String dbName = "Escuela";
    String port = "1433";
    Connection connection;
    

    public Conexion() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";database="+dbName+";user="+user+";password="+password+";trustServerCertificate=true;");
            System.out.println("Connection established successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to close connection.");
        }
    }
}

