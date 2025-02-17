/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author xdGHOSTbx
 */
public class CalculadoraController implements Initializable {
  double num1 = 0;
  double resultado;
  String operador ="";
  
  @FXML 
  private TextField pantalla;
  
  @FXML
    private void generarNumero (ActionEvent event){
        
        //Variables para almacenar los operandos a sumar.
        Button boton = (Button) event.getSource();
        
        String numero = boton.getText();
        pantalla.setText(pantalla.getText()+numero);
    }
    
    @FXML
      private void operacion(ActionEvent event) {
      // Guardar el número actual de la pantalla en num1 y limpiar pantalla para el nuevo número.
      num1 = Double.parseDouble(pantalla.getText());
      operador = ((Button) event.getSource()).getText();
      pantalla.clear();
  }
    
    @FXML
      private void igual(ActionEvent event) {
          double num2 = Double.parseDouble(pantalla.getText());
          double resultado = calcularResultado(num1, num2, operador);
          pantalla.setText(String.valueOf(resultado));
          num1 = resultado;  // Prepara num1 para la próxima operación.
      }
    
    private double calcularResultado(double num1, double num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "X":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    pantalla.setText("Error: División por cero");
                    return Double.NaN;
                }
            default:
                return 0;
        }
    }
    
    @FXML
    private void reset (ActionEvent event){
        num1= 0;
        pantalla.clear();
        operador = "";
    }
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }  
  
}
