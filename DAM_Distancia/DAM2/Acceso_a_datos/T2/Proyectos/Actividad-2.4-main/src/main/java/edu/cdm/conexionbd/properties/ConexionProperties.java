package edu.cdm.conexionbd.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionProperties {

    private static final String PROVIDER_PROPERTIES_KEY = "provider";
    private static final String PROVIDER_VALUE_MYSQL = "MYSQL";
    private static final String PROVIDER_VALUE_SQLSERVER = "SQLSERVER";
    

    public static String createUrlConnection(String path) throws IOException {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream(path)) {
            // Cargamos en memoria el fichero de properties
            properties.load(input);
            return createUrl(properties.getProperty(PROVIDER_PROPERTIES_KEY), properties);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

    private static String createUrl(String proveedor, Properties properties) {

        switch (proveedor) {
            case PROVIDER_VALUE_SQLSERVER :
                return createUrlSQLServer(properties);

            case PROVIDER_VALUE_MYSQL:
                // TODO
                break;

            default:
            throw new UnsupportedOperationException("El proveedor no está entre los permitidos"); 
                
        }
        return null;

    }

    public static void main(String[] args) {

        String url;
        try {
            url = createUrlConnection("src/main/resources/db.sqlserver.properties");

            // Establish the connection
            try (Connection connection = DriverManager.getConnection(url)) {
                System.out.println("Connected to the database successfully!");
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String createUrlSQLServer(Properties properties) {
        // Recuperamos la propiedad url
        String url = properties.getProperty("url");
        // Concatenamos valores para obtener la cadena de conexión para SQL Server
        StringBuilder concatenatedValues = new StringBuilder();
        concatenatedValues.append(url);
        concatenatedValues.append(";");

        // "jdbc:sqlserver://localhost:1433;database=empresa;user=user;password=abc123.;trustServerCertificate=true;");

        // Concatenate all values into a single string

        for (String key : properties.stringPropertyNames()) {
            if (!"url".equals(key)) {
                concatenatedValues.append(key);
                concatenatedValues.append("=");
                concatenatedValues.append(properties.getProperty(key));
                concatenatedValues.append(";");
            }
        }

        // System.out.println(concatenatedValues.toString());
        return concatenatedValues.toString();

    }

}
