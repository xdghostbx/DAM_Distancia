package tablaconcesionario;

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
public class ConcesionarioController implements Initializable {
  
  @FXML
  private TextField tfMarca;
  
  @FXML
  private TextField tfMatricula;
  
  @FXML
  private TextField tfKilometros;
  
  @FXML
  private TextField tfDescripcion;
  
  @FXML
  private TextField tfPrecio;
  
  @FXML
  private TextField tfNombre;
  
  @FXML
  private TextField tfDNI;
  
  @FXML
  private TableView<Vehiculo> tablaConcesionario;
  
  @FXML
  private TableColumn<Vehiculo, String> tMarca;
  
  @FXML
  private TableColumn<Vehiculo, String> tMatricula;
  
  @FXML
  private TableColumn<Vehiculo, Integer> tKilometros;
  
  @FXML
  private TableColumn<Vehiculo, Double> tPrecio;
  
  @FXML
  private TableColumn<Vehiculo, String> tNombre;
  
  @FXML
  private TableColumn<Vehiculo, String> tDNI;
  
  @FXML
  private TableColumn<Vehiculo, String> tDescripcion;

  
  private ObservableList<Vehiculo> listaConcesionario = FXCollections.observableArrayList();
  
  
  /*@FXML
    private void initialize() {
        tName.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        tAp.setCellValueFactory(cellData -> cellData.getValue().apellidosProperty());
        tEdad.setCellValueFactory(cellData -> cellData.getValue().getEdadAsObservable());

        tablaPersonas.setItems(listaPersonas);
    }*/
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        tMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        tKilometros.setCellValueFactory(new PropertyValueFactory<>("numKilometros"));
        tPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        tNombre.setCellValueFactory(new PropertyValueFactory<>("nombrePropietario"));
        tDNI.setCellValueFactory(new PropertyValueFactory<>("dniPropietario"));
        tDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        tablaConcesionario.setItems(listaConcesionario);
        
        tablaConcesionario.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                tfMarca.setText(newSelection.getMarca());
                tfMatricula.setText(newSelection.getMatricula());
                tfDescripcion.setText(newSelection.getDescripcion());
                tfPrecio.setText(String.valueOf(newSelection.getPrecio()));
                tfKilometros.setText(String.valueOf(newSelection.getNumKilometros()));
                tfNombre.setText(newSelection.getNombrePropietario());
                tfDNI.setText(newSelection.getDniPropietario());
            }
        });
    }

  @FXML
    private void agregarVehiculo(ActionEvent event) {
        try {
            String marca = tfMarca.getText();
            String matricula = tfMatricula.getText();
            int kilometros = Integer.parseInt(tfKilometros.getText());
            double precio = Double.parseDouble(tfPrecio.getText());
            String nombre = tfNombre.getText();
            String dni = tfDNI.getText();
            String descripcion = tfDescripcion.getText();
            

            Vehiculo nuevoVehiculo = new Vehiculo(marca, matricula, kilometros,descripcion, precio, nombre, dni);
            listaConcesionario.add(nuevoVehiculo);

            tfMarca.clear();
            tfMatricula.clear();
            tfKilometros.clear();
            tfPrecio.clear();
            tfNombre.clear();
            tfDNI.clear();
            tfDescripcion.clear();
            
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Introduce un número válido");
        }
    }
    
    @FXML
    private void modificarVehiculo(ActionEvent event) {
        Vehiculo selectedVehiculo = tablaConcesionario.getSelectionModel().getSelectedItem();
        if (selectedVehiculo != null) {
          
            selectedVehiculo.setMarca(tfMarca.getText());
            selectedVehiculo.setMatricula(tfMatricula.getText());
            selectedVehiculo.setNumKilometros(Integer.parseInt(tfKilometros.getText()));
            selectedVehiculo.setDescripcion(tfDescripcion.getText());
            selectedVehiculo.setPrecio(Double.parseDouble(tfPrecio.getText()));
            selectedVehiculo.setNombrePropietario(tfNombre.getText());
            selectedVehiculo.setDniPropietario(tfDNI.getText());
            tablaConcesionario.refresh();
        }
    }
    
    @FXML
    private void eliminarVehiculo(ActionEvent event) {
        int selectedIndex = tablaConcesionario.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tablaConcesionario.getItems().remove(selectedIndex);
        }
    }
    
  
}