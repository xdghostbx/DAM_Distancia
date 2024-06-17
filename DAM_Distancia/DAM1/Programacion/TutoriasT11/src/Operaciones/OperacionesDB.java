/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Operaciones;

import java.sql.*;

/**
 * Metodos:
 *  AbrirConexion()
 *  cerrarConexion()
 *  añadeAlumno()
 *  consultaAlumno()
 *  borraAlumno()
 *  modificaAlumno()
 *  listaAlumno()
 * 
 *
 * @author xdGHOSTbx
 */
public class OperacionesDB {
    private final String driver = "org.mariadb.jdbc.Driver";
    private final String url = "jdbc:mariadb://localhost:3306/escuela";
    private final String usuario = "root";
    private final String password = "root";
    
    private Connection conexion = null;
    /* Copiar y pegar para MYSql
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/universidad";
    private final String usuario = "root";
    private final String password = "root";
    
    conexion =DriverManager.getConnection(url,"root","abc123.");
    */
    /**
     * Metodo para iniciar la conexion a la base de datos
    * @return conexion a la base de datos
     */
    public Connection abrirConexion() {
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
    
    /*
    * Metodo para añadir un nuevo alumno a la base de datos
    */
    
    public void añadirAlumno(Alumno alumno){
      abrirConexion();
      String consulta = "INSERT INTO alumnos(dni,nombre,apellidos,edad)VALUES(?,?,?,?)";
      try (PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, alumno.getDni());
        sql.setString(2, alumno.getNombre());
        sql.setString(3, alumno.getApellios());
        sql.setInt(4, alumno.getEdad());
        int filasActualizadas = sql.executeUpdate();
        if (filasActualizadas > 0){
          System.out.println("Alumno ingresado con exito");
        }
      }catch(SQLException ex){
        System.out.println("Error al añadir alumno: "+ex.getMessage());
      }finally{
        cerrarConexion();
      }
              
    }
    
    public void consultaAlumno (String dni){
      abrirConexion();
      String consulta = "SELECT * FROM alumnos WHERE dni = ?";
      try(PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1,dni);
        ResultSet resultSet = sql.executeQuery();
        if (resultSet.next()){
          System.out.println("Alumno entontrado: "+ resultSet.getString("nombre")+" " +resultSet.getString("apellidos"));
        }else{
          System.out.println("No se ha encontrado un alumno con DNI: "+dni);
        }
      }catch(SQLException ex){
        System.out.println("Error al consultar el alumno: "+ex.getMessage());
      }finally{
        cerrarConexion();
      }
    }
    
    public void eliminarAlumno(String dni){
      abrirConexion();
      String consulta ="DELETE FROM alumnos WHERE dni = ?";
      try(PreparedStatement sql = conexion.prepareStatement(consulta)){
        sql.setString(1, dni);
        int filasBorradas = sql.executeUpdate();
        if (filasBorradas > 0){
          System.out.println("Alumno borrado con exito");
        }else{
          System.out.println("No se ha encontrado un alumno con DNI: "+dni);
        }
      }catch(SQLException ex){
        System.out.println("Error al borrar al alumno: "+ex.getMessage());
      }finally{
        cerrarConexion();
      }
    }
    
    
    public void modificaAlumno(Alumno alumno) {
        abrirConexion();
        String consulta = "UPDATE alumnos SET nombre = ?, apellidos = ?, edad = ? WHERE dni = ?";
        try (PreparedStatement sql = conexion.prepareStatement(consulta)) {
            sql.setString(1, alumno.getNombre());
            sql.setString(2, alumno.getApellios());
            sql.setInt(3, alumno.getEdad());
            sql.setString(4, alumno.getDni());

            int rowsUpdated = sql.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Alumno actualizado con éxito.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar alumno: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }
    
    
    public void listaAlumnos(){
      abrirConexion();
      String consulta ="SELECT * FROM alumnos";
      try(PreparedStatement sql = conexion.prepareStatement(consulta)){
        ResultSet a = sql.executeQuery();
        while(a.next()){
          System.out.println(a.getString("dni") + " - " + a.getString("nombre") + " " + a.getString("apellidos") + ", Edad: " + a.getInt("edad"));
        }
      }catch(SQLException ex){
        System.out.println("Error al listar alumnos: "+ex.getMessage());
      }finally{
        cerrarConexion();
      }
    }    
}

