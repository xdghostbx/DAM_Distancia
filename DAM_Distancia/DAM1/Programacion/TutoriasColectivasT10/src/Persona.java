
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

/*
 * Copyright 2023 Módulo Programación
 * https://www.edu.xunta.gal/fpadistancia/
 */

/**
 *
 * @author xdGHOSTbx
 */
public class Persona {
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleIntegerProperty edad;

    public Persona(String nombre, String apellidos, int edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
    }

    public int getEdad() {
        return edad.get();
    }

    public void setEdad(int edad) {
        this.edad.set(edad);
    }
    
    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public SimpleStringProperty apellidosProperty() {
        return apellidos;
    }

    public SimpleIntegerProperty edadProperty() {
        return edad;
    }
    public ObservableValue<Integer> getEdadAsObservable() {
        return new ReadOnlyObjectWrapper<>(edad.get());
    }
}
