/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package EditorTexto;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class EditorDeTexto extends JTextField implements Serializable {
    
    private Color color;
    
    private Font fuente;
    
    private int ancho;
    
    private PropertyChangeSupport propertySupport ;
    
    public EditorDeTexto() {
        super();
        propertySupport = new PropertyChangeSupport(this);
        // Evitamos posibles errores durante la inicialización
        this.setColumns(20);  // Asignamos un valor predeterminado a columnas
        this.setFont(new Font("Arial", Font.PLAIN, 12)); // Valor predeterminado para la fuente
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        this.setEditable(true);
        System.out.println("Editor de texto creado");// Color por defecto
    }

    /**
     * Get the value of ancho
     *
     * @return the value of ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * Set the value of ancho
     *
     * @param ancho new value of ancho
     */
    public void setAncho(int ancho) {
        int anchoViejo = this.ancho;
        this.ancho = ancho;
        this.setColumns(ancho);
        propertySupport.firePropertyChange("ancho", anchoViejo, ancho);
    }


    /**
     * Get the value of fuente
     *
     * @return the value of fuente
     */
    public Font getFuente() {
        return fuente;
    }

    /**
     * Set the value of fuente
     *
     * @param fuente new value of fuente
     */
    public void setFuente(Font fuente) {
        Font fuenteVieja = this.fuente;
        this.fuente = fuente;
        this.setFont(fuente);
        propertySupport.firePropertyChange("fuente", fuenteVieja, fuente);
    }

    /**
     * Get the value of color
     *
     * @return the value of color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Set the value of color
     *
     * @param color new value of color
     */
    public void setColor(Color color) {
        Color colorViejo = this.color;
        this.color = color;
        this.setForeground(color);
        propertySupport.firePropertyChange("color", colorViejo, color);
    }
 
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // Aseguramos que el listener se añada correctamente
        if (propertySupport != null) {
            propertySupport.addPropertyChangeListener(listener);
        }
    }

    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (propertySupport != null) {
            propertySupport.removePropertyChangeListener(listener);
        }
    }
    
}
