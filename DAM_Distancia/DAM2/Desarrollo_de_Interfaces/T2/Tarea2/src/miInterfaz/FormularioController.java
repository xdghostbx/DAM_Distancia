/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package miInterfaz;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class FormularioController implements Initializable {

    @FXML
    private Button bt1;
    @FXML
    private RadioButton rb_Hombre;
    @FXML
    private ToggleGroup genero;
    @FXML
    private RadioButton rb_mujer;
    @FXML
    private RadioButton rb_noContesta;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    @FXML
    private TextField txt4;
    @FXML
    private Label label;
    @FXML
    private CheckBox cb_fumador;
    @FXML
    private CheckBox cb_genero;
    @FXML
    private RadioButton rb_1;
    @FXML
    private ToggleGroup fumar;
    @FXML
    private RadioButton rb_5;
    @FXML
    private RadioButton rb_1o;
    @FXML
    private MenuItem menu_cambio;
    @FXML
    private ComboBox combo_box;
    @FXML
    private Spinner<?> sp_edad;
    @FXML
    private Button boton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*
            -   Revisar como añadir funcionalidad a un spinner pero para tontos
            -   Añadir un cambio de ventana por si lo pide para un formulario 
        */
        
        combo_box.getItems().addAll("Hola","Adios","Marcho"); //borrar desde la declaracion el <?> y funciona de esta forma
        
        System.out.println("Programa cargado con exito");
        //this.txt2.setVisible(false);
    }    

    @FXML
    private void recogerDatos(ActionEvent event) {
        String nombre = this.txt1.getText();
        System.out.println("Nombre recogido: "+nombre);
        label.setText(nombre.toString());
        
        if (rb_Hombre.isSelected()){
            System.out.println("Un man");
            txt2.setVisible(false);
            txt3.setVisible(false);
            txt4.setVisible(false);
        }else if (rb_mujer.isSelected()){
            System.out.println("Una woman");
        }else if (rb_noContesta.isSelected()){
            System.out.println("Indefinido");
        }else System.out.println("No contesta");
        
        
        
        
        
    }

    @FXML
    private void mostratGeneros(ActionEvent event) {
        if(cb_genero.isSelected()){
            rb_Hombre.setVisible(true);
            rb_mujer.setVisible(true);
            rb_noContesta.setVisible(true);
        }else {
            rb_Hombre.setVisible(false);
            rb_mujer.setVisible(false);
            rb_noContesta.setVisible(false);
        }        
    }

    @FXML
    private void mostrarTabaco(ActionEvent event) {
        if (cb_fumador.isSelected()){
            rb_1.setVisible(true);
            rb_5.setVisible(true);
            rb_1o.setVisible(true);
        }else {
            rb_1.setVisible(false);
            rb_5.setVisible(false);
            rb_1o.setVisible(false);
        }
    }

    @FXML
    private void cambiarVentana(ActionEvent event) {
        
            /*try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SegundaVentana.fxml"));
            Parent root = loader.load();
            
            SegundaVentanaController sVentanaControlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.NONE);
            stage.setScene(scene);
            stage.show();
            } catch (IOException ex) {
            Logger.getLogger(FormularioController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            
           /* FXMLLoader loader = new FXMLLoader(getClass().getResource("SegundaVentana.fxml"));
            Parent root = loader.load();
            Stage nueva = new Stage();
            nueva.setScene(new Scene(root));
            nueva.show();*/
        
    }

    @FXML
    private void boton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SegundaVentana.fxml"));
            Parent root = loader.load();
            Stage nueva = new Stage();
            nueva.setScene(new Scene(root));
            nueva.show();
        } catch (IOException ex) {
            Logger.getLogger(FormularioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
