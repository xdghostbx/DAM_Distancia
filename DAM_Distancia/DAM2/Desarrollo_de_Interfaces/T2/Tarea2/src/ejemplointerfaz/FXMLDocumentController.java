/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ejemplointerfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Agustin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML private ComboBox comboBox;
    @FXML private CheckBox checkBox;
    @FXML private Label labelAviso;
    @FXML private Button btCerrar;
    @FXML private Button btAceptar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       comboBox.getItems().addAll("Doble de uso individual","Doble","Junior Suite","Suite");
       labelAviso.setVisible(false);

    }    
        public void handleCheckBox(){
            if (checkBox.isSelected()){
                //etiqueta será visible
               labelAviso.setVisible(true);
            }else{
                 labelAviso.setVisible(false);
            }
        }
        
        @FXML
    public void cerrar(ActionEvent event) throws IOException {
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

