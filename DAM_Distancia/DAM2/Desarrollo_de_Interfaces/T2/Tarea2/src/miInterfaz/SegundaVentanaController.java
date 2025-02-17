/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package miInterfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class SegundaVentanaController implements Initializable {

    @FXML
    private Button bton_cerrar;
    
    
    @FXML
    private DatePicker dp_prueba;
    @FXML
    private AnchorPane sp_test;
    @FXML
    private Spinner<Integer> sp_prueba;
    @FXML
    private Spinner<Integer> sp_prueba1;
    @FXML
    private Spinner<Integer> sp_prueba2;
    @FXML
    private RadioButton color1;
    @FXML
    private ToggleGroup colores;
    @FXML
    private RadioButton color2;
    @FXML
    private RadioButton color3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        /*
            Metodo para ponerle valor a un spinner
                primer numero, valor minimo
                segundo numero, valor maximo
                tercer numero, numero seleccionado
        */
        //Spiner swing
        //jSpinner1 = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(1,1,10,1));
        
        //Spinner fx
        sp_prueba2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,31,1));
        sp_prueba1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 1));
        sp_prueba.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1970, 2024,2010));
    }    

    @FXML
    private void cerrar(ActionEvent event) {
        
        
        String fecha = sp_prueba2.getValue()+"/"+sp_prueba1.getValue()+"/"+sp_prueba.getValue();
        
        //Metodo para lanzar una alerta
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(fecha);
        alert.showAndWait();
        
        //Metodo para cerrar la ventana actual desde un boton
        Stage stage = (Stage)this.bton_cerrar.getScene().getWindow();
        stage.close();  
        
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setHeaderText("hola");
        a.setTitle("Adios");
        a.setContentText("contenido");
        a.showAndWait();
        
    }

    @FXML
    private void color1(ActionEvent event) {
        if(color1.isSelected()){
            bton_cerrar.setVisible(false);
        }else{
        }
    }

    @FXML
    private void color2(ActionEvent event) {
        if(color2.isSelected()){
            bton_cerrar.setVisible(true);
        }else{}
    }

    @FXML
    private void color3(ActionEvent event) {
        if(color3.isSelected()){
        }else{}
    }
    
}
