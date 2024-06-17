/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */
package Principal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author xdGHOSTbx
 */
public class MiniCalcVentanaController implements Initializable {

    @FXML
    private TextField tfNumero1;
    
    @FXML
    private TextField tfNumero2;
    
    @FXML
    private TextField tfResultado;
    
    @FXML
    private void buttonSumarHandler (ActionEvent event){
        //Variables para almacenar los operandos a sumar.
        int num1, num2, resul;
        
        num1= Integer.parseInt(tfNumero1.getText());
        num2= Integer.parseInt(tfNumero2.getText());
        
        //Ya hemos recogido el valor de los operados de los campos de texto de la interfaz. Realizamos la suma.
        resul=num1+num2;
        
        tfResultado.setText(String.valueOf(resul));
    }
    
    @FXML
    private void buttonSalirHandler (ActionEvent event){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
  
