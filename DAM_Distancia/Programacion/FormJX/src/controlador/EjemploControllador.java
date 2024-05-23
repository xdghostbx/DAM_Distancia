/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;

import modelo.*;
import baseDatos.*;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author xdGHOSTbx
 */
public class EjemploControllador implements Initializable {

  @FXML
  private TextField tf_id;
  @FXML
  private TextField tf_mat;
  @FXML
  private ToggleGroup concesionario;
  @FXML
  private Button bt_buscar;
  @FXML
  private TableColumn t_c1;
  @FXML
  private TableColumn t_c2;
  @FXML
  private TableColumn t_c3;
  @FXML
  private TableView<Propietarios> tabla_dinamica;
  @FXML
  private TableView<vehiculos> tabla_dinamica1;
  @FXML
  private TableColumn t2_c1;
  @FXML
  private TableColumn t2_c2;
  @FXML
  private TableColumn t3_c3;
  @FXML
  private TableColumn t3_c4;
  @FXML
  private TableColumn t3_c5;
  @FXML
  private TableColumn t3_c6;
  
  //crear algo necesairo para incorporar los datos, como un array list de java fx
  private ObservableList <Propietarios> persona;
  private ObservableList <vehiculos> coche;
  
  private Connection conexion;
  @FXML
  private Button bt_guardar;
  
  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    ConnectionDB conn = new ConnectionDB();
    conexion = conn.abrirConexion();
    
    configuraTablas();
    persona = FXCollections.observableArrayList();
    coche = FXCollections.observableArrayList();
  }
  private void configuraTablas(){
    this.t_c1.setCellValueFactory(new PropertyValueFactory("id_prop"));
    this.t_c2.setCellValueFactory(new PropertyValueFactory("nombre_prop"));
    this.t_c3.setCellValueFactory(new PropertyValueFactory("dni_prop"));
    
    this.t2_c1.setCellValueFactory(new PropertyValueFactory("matricula"));
    this.t2_c2.setCellValueFactory(new PropertyValueFactory("marca"));
    this.t3_c3.setCellValueFactory(new PropertyValueFactory("kilometros"));
    this.t3_c4.setCellValueFactory(new PropertyValueFactory("precio"));
    this.t3_c5.setCellValueFactory(new PropertyValueFactory("descripcion"));
    this.t3_c6.setCellValueFactory(new PropertyValueFactory("id_prop"));
  }
  @FXML
  private void buscar(ActionEvent event) {
    try{
      if(tf_id.getText().isEmpty() && tf_mat.getText().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Introduce un dato");
        alert.show();
        return;
      }
      
      if(!tf_id.getText().isEmpty()){
        buscarPropietarios(tf_id.getText());
        tf_id.clear();
      }else{
        buscarVehiculos(tf_mat.getText());
        tf_mat.clear();
      }
    } catch(SQLException ex){
      ex.printStackTrace();
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText("Error al realizar la consulta");
      alert.show();
    }
  }
  
  private void buscarPropietarios(String id) throws SQLException {
        String query = "SELECT * FROM propietarios WHERE id_prop = ?";
        PreparedStatement pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();

        // Asignar resultados a la tabla, suponiendo que DataModel es tu modelo de datos
        while (rs.next()) {
            persona.add(new Propietarios(rs.getInt("id_prop"), rs.getString("nombre_prop"), rs.getString("dni_prop")));
        }
        tabla_dinamica.setItems(persona);
    }
  
  private void buscarVehiculos(String matricula) throws SQLException {
        String query = "SELECT * FROM vehiculos WHERE mat_veh = ?";
        PreparedStatement pstmt = conexion.prepareStatement(query);
        pstmt.setString(1, matricula);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            coche.add(new vehiculos(rs.getString("mat_veh"), rs.getString("marca_veh"), rs.getFloat("kms_veh"), rs.getFloat("precio_veh"), rs.getString("desc_veh"), rs.getInt("id_prop")));
        }
        tabla_dinamica1.setItems(coche);
    }

  @FXML
  private void visible1(ActionEvent event) {
    tabla_dinamica.setVisible(true);
    tabla_dinamica1.setVisible(false);
    tf_id.setVisible(true);
    tf_mat.setVisible(false);
  }

  @FXML
  private void visible2(ActionEvent event) {
    tabla_dinamica.setVisible(false);
    tabla_dinamica1.setVisible(true);
    tf_id.setVisible(false);
    tf_mat.setVisible(true);
  }

 @FXML
private void guardar(ActionEvent event) {
    FileWriter fw = null;
    BufferedWriter bw = null;
    try {
        fw = new FileWriter("C:\\Users\\xdGHOSTbx\\Desktop\\Documentos Ciclo\\DAM_Distancia_1\\DAM_Distancia\\Programacion\\FormJX\\src\\guardar.txt");
        bw = new BufferedWriter(fw);
        
        for (Propietarios prop : persona) {
            bw.write(prop.getId_prop() + "," + prop.getNombre_prop() + "," + prop.getDni_prop());
            bw.newLine();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Datos guardados correctamente");
        alert.show();
    } catch (IOException e) {
        System.out.println("Error al guardar los datos: " + e.getMessage());
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Error al guardar los datos");
        alert.show();
    } finally {
        try {
            if (bw != null) {
                bw.close();
            }
            if (fw != null) {
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo: " + e.getMessage());
        }
    }
}
}

       
