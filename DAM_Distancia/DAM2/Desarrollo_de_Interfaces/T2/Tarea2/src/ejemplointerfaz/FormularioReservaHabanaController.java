/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ejemplointerfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FormularioReservaHabanaController implements Initializable {
    @FXML private ComboBox cb_tipoEvento;
    @FXML private ComboBox cb_tipoCocina;
    @FXML private Spinner sp_Asistentes;
    @FXML private DatePicker dp_Fecha;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_tipoEvento.getItems().addAll("Banquete","Jornada","Congreso");
        cb_tipoCocina.getItems().addAll("Buffet","Carta","Cita con el Cheff","No precisa");
        
        SpinnerValueFactory<Integer> valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);

        sp_Asistentes.setValueFactory(valueFactory);
    }    
    @FXML
    private void aceptar (ActionEvent evento)throws IOException {
        mostrarAlertDatos(evento);
        System.out.println("datos guardados con exito");
        cambiarEscena(evento);
    }
    @FXML
    private void cancelar (ActionEvent evento)throws IOException {
        mostrarAlertConfirmation(evento);
        cambiarEscena(evento);
    }
    
    @FXML
    private void mostrarAlertConfirmation(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmacion");
        alert.setContentText("¿Deseas realmente calcelar?");
        alert.showAndWait();
    }
    
    @FXML
    private void mostrarAlertDatos(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Datos:");
        alert.setContentText("El tipo de evento es: "+cb_tipoEvento.getValue().toString()+"\n"+
                             "El numero de asistentes es de: "+sp_Asistentes.getValue().toString()+"\n"+
                             "El tipo de Cocina: " + cb_tipoCocina.getValue().toString()+"\n"+
                             "En la fecha: " + dp_Fecha.getValue().toString()
                );
        alert.showAndWait();
    }
    @FXML
    public void cambiarEscena(ActionEvent event) throws IOException{
     // Cargar la segunda escena
        Parent root = FXMLLoader.load(getClass().getResource("FormularioPrincipal.fxml"));
        
        // Obtener el Stage actual desde el evento
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        // Configurar la nueva escena
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
