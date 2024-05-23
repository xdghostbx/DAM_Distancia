package baseDatos;

import java.io.File;  //io son los paquetes para extraer o importar los datos
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Consultas {
    private ConnectionDB dbConnection;

    public Consultas() {
        this.dbConnection = new ConnectionDB();
    }
    //creamos la tabla
    public void crearTablaSiNoExiste() {
        String sqlCreate = "CREATE TABLE IF NOT EXISTS Vehiculos (" +
                           "id INT AUTO_INCREMENT PRIMARY KEY, " +
                           "matricula VARCHAR(255) NOT NULL UNIQUE, " +
                           "marca VARCHAR(255) NOT NULL, " +
                           "descripcion TEXT, " +
                           "kilometros DOUBLE, " +
                           "precio DECIMAL(10, 2), " +
                           "fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
        try (Connection conn = dbConnection.abrirConexion();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sqlCreate);
            System.out.println("Tabla 'Vehiculos' verificada/creada.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        } finally {
            dbConnection.cerrarConexion();
        }
    }

    public void insertarOActualizarVehiculo(String matricula, String marca, String descripcion, double kms, double precio) {
        String sql = "INSERT INTO vehiculos (matricula, marca, descripcion, kilometros, precio) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE marca=?, descripcion=?, kilometros=?, precio=?";
        try (Connection conn = dbConnection.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setString(2, marca);
            pstmt.setString(3, descripcion);
            pstmt.setDouble(4, kms);
            pstmt.setDouble(5, precio);
            pstmt.setString(6, marca);
            pstmt.setString(7, descripcion);
            pstmt.setDouble(8, kms);
            pstmt.setDouble(9, precio);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al insertar o actualizar vehículo: " + ex.getMessage());
        }
    }
    //este metodo carga los datos guardados en el txt a la consulta
    //ver en el principal
    public void actualizarDesdeTxt() {
        File archivo = new File("ListadoVehiculos.txt");
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String matricula = datos[0].trim();
                    String marca = datos[1].trim();
                    String descripcion = datos[2].trim();
                    double kms = Double.parseDouble(datos[3].trim());
                    double precio = Double.parseDouble(datos[4].trim());
                    insertarOActualizarVehiculo(matricula, marca, descripcion, kms, precio);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear número: " + e.getMessage());
        }
    }
}


