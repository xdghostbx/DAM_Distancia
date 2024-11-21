/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ejemplointerfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author 
 */
public class FormularioPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML private Button btnReservas;
     @FXML private Button btnSalir;
     @FXML private Button bt_habana;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void handlebtnReservas(ActionEvent event) throws IOException{
     Stage stage =(Stage) btnReservas.getScene().getWindow(); 
     Parent root = FXMLLoader.load(getClass().getResource("FormularioPrincipal.fxml"));
     if(event.getSource()==btnReservas){
        //Obtener referencia a la Escena del botón         
        stage=(Stage) btnReservas.getScene().getWindow();
        //cargar el otro documento, en este caso la segundo pantalla
         root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      }
     
     //Crear una nueva escena con raíz y establecer el escenario
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
}
     public void handlebtnSalir(ActionEvent event) throws IOException{
        Platform.exit();
        System.exit(0);
     }
     
    public void handleBT_Habana(ActionEvent event) throws IOException{
     Stage stage =(Stage) bt_habana.getScene().getWindow(); 
     Parent root = FXMLLoader.load(getClass().getResource("FormularioPrincipal.fxml"));
     if(event.getSource()==bt_habana){
        //Obtener referencia a la Escena del botón         
        stage=(Stage) bt_habana.getScene().getWindow();
        //cargar el otro documento, en este caso la segundo pantalla
         root = FXMLLoader.load(getClass().getResource("FormularioReservaHabana.fxml"));
      }
     
     //Crear una nueva escena con raíz y establecer el escenario
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
}
}