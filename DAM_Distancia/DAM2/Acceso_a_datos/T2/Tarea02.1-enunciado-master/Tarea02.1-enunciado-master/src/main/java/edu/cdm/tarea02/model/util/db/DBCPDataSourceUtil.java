package edu.cdm.tarea02.model.util.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPDataSourceUtil {

    private static final String DB_CONFIG_FILE = Paths.get("src", "main", "resources", "db.properties")
            .toString();
    // Las claves del fichero Properties:
    private static final String DB_DRIVER_CLASS = "_DB_DRIVER_CLASS";
    private static final String DB_URL = "_DB_URL";
    private static final String DB_USERNAME = "_DB_USERNAME";
    private static final String DB_PASSWORD = "_DB_PASSWORD";

    public   enum DB_SUPPORTED_TYPES  {MYSQL, SQLSERVER};

    // Los SGBD soportados
    private static final String SELECTED_SGBD = "SELECTED_SGBD";

    public static DataSource getDataSource() {

        String driverClassName;
        String url;
        String username;
        String password;

        Properties props = new Properties();

        try (
                FileInputStream fis = new FileInputStream(DB_CONFIG_FILE);) {
            props.load(fis);

            String dbType = props.getProperty(SELECTED_SGBD);

            driverClassName = props.getProperty(concatString(dbType, DB_DRIVER_CLASS));
            url = props.getProperty(concatString(dbType, DB_URL));
            username = props.getProperty(concatString(dbType, DB_USERNAME));
            password = props.getProperty(concatString(dbType, DB_PASSWORD));

            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName(driverClassName);
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            return basicDataSource;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String concatString(String dbType, String propertySuffix) {
        return dbType + propertySuffix;
    }

    public static DB_SUPPORTED_TYPES getDBType() throws Exception {
        Properties props = new Properties();

        try (
                FileInputStream fis = new FileInputStream(DB_CONFIG_FILE);) {
            props.load(fis);

            String dbType = props.getProperty(SELECTED_SGBD);
            if(DB_SUPPORTED_TYPES.MYSQL.name().equals(dbType) )
            return DB_SUPPORTED_TYPES.MYSQL;
            else if(DB_SUPPORTED_TYPES.SQLSERVER.name().equals(dbType)){
                return DB_SUPPORTED_TYPES.SQLSERVER;
            }
            else{
                throw new UnsupportedOperationException("DB type "+ dbType + " is not supported");
            }
            
        } catch (Exception ex) {

            ex.printStackTrace();
            throw ex;
        }
    }
}
