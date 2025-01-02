/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package miInterfaz;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Main extends Application {

    
    @Override
    public void start(Stage primaryStage) {

        try {
            //Cargo la vista
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("formulario.fxml"));
            
            // Cargo la ventana
            Pane ventana = (Pane) loader.load();
            
            // Cargo el scene
            Scene scene = new Scene(ventana);
            
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("esto no carga");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
