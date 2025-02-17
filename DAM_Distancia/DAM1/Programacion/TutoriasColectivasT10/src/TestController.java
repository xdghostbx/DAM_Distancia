import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author xdGHOSTbx
 */
public class TestController implements Initializable {
  double num1, num2, res;
  
  @FXML
  private TextField tfnombre;
  
  @FXML
  private TextField tfapellido;
  
  @FXML
  private TextField tfedad;
  
  @FXML
  private TableView<Persona> tablaPersonas;
  @FXML
  private TableColumn<Persona, String> tName;
  @FXML
  private TableColumn<Persona, String> tAp;
  @FXML
  private TableColumn<Persona, Integer> tEdad;
  
  
  private ObservableList<Persona> listaPersonas = FXCollections.observableArrayList();
  
  
  /*@FXML
    private void initialize() {
        tName.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        tAp.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        tEdad.setCellValueFactory(cellData -> cellData.getValue().getEdadAsObservable());

        tablaPersonas.setItems(listaPersonas);
    }*/
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        tName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tAp.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
        tEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        tablaPersonas.setItems(listaPersonas);
        
        tablaPersonas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tfnombre.setText(newSelection.getNombre());
                tfapellido.setText(newSelection.getApellidos());
                tfedad.setText(String.valueOf(newSelection.getEdad()));
            }
        });
    }

  @FXML
    private void agregarPersona(ActionEvent event) {
        try {
            String nombre = tfnombre.getText();
            String apellidos = tfapellido.getText();
            int edad = Integer.parseInt(tfedad.getText());

            Persona nuevaPersona = new Persona(nombre, apellidos, edad);
            listaPersonas.add(nuevaPersona);

            tfnombre.clear();
            tfapellido.clear();
            tfedad.clear();
        } catch (NumberFormatException e) {
            System.out.println("Error: Introduce un número válido para la edad.");
        }
    }
    
    @FXML
    private void modificarPersona(ActionEvent event) {
        Persona selectedPersona = tablaPersonas.getSelectionModel().getSelectedItem();
        if (selectedPersona != null) {
            selectedPersona.setNombre(tfnombre.getText());
            selectedPersona.setApellidos(tfapellido.getText());
            selectedPersona.setEdad(Integer.parseInt(tfedad.getText()));
            tablaPersonas.refresh();
        }
    }
    
    
    @FXML
    private void eliminarPersona(ActionEvent event) {
        int selectedIndex = tablaPersonas.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tablaPersonas.getItems().remove(selectedIndex);
        }
    }
    
  
}

