/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 *
 * @author USER
 */
public class Persona implements Serializable {
    private String nombre;
    private String telefono;
    private boolean presente;
    private PropertyChangeSupport cambios = new PropertyChangeSupport(this);

    public Persona(String nombre, String telefono, boolean presente) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.presente = presente;
    }
    
    public Persona() {} //constructor vacío

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean actu) {
        boolean viejo = this.presente;
        this.presente = actu;
        
        cambios.firePropertyChange("presente",viejo, actu);
    }
    
    public void addPropertyChangeListener ( PropertyChangeListener listener) {
        cambios.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener (PropertyChangeListener listener) {
        cambios.removePropertyChangeListener(listener);
    }
}
