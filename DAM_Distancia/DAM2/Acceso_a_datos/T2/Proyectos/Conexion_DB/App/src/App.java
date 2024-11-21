import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        //establecer conexion con la BD
        String user = "dani";
        String password = "dani";
        String dbName = "empresa";
        String port = "1433";
        
        try {
            
            Connection conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:"+port+";database="+dbName+";user="+user+";password="+password+";trustServerCertificate=true;");
            System.out.println("Conexion establecida");
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
