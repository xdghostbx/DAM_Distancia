import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws Exception {
        
        String user = "dani";
        String password = "dani";
        String dbName = "empresa";
        String url = "jdbc:sqlserver://localhost:1433;dataBase="+dbName+";user="+user+";+password="+password+";trustServerCertificate=true;";
        String url2= "jdbc:sqlserver://localhost:1433;database="+dbName+";user="+user+";password="+password+";trustServerCertificate=true;";
        
        try {
            //Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database="+dbName+";user="+user+";password="+password+";trustServerCertificate=true;");
            Connection conexion2 = DriverManager.getConnection(url);
            Connection conexion3 = DriverManager.getConnection(url2);
               // if (conexion != null) System.out.println("Conexion1 establecida");
                if (conexion2 != null) System.out.println("Conexion2 establecida");
                if(conexion3 != null) System.out.println("Conexion3 establecida");
            
           // conexion.close();
            //conexion2.close();
            conexion3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
