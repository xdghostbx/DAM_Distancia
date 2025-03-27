/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package PruebasExamenDI.beanSuperCompleto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author USER
 */
public class reloj extends JLabel implements Serializable {
    
    public static final String VARIABLE_HORAS = "horas";
    public static final String VARIABLE_MINUTOS = "minutos";
    public static final String VARIABLE_SEGUNDOS = "segundos";
    
    public static final String VARIABLE_ALARMA_HORA = "alarmaHora";
    public static final String VARIABLE_ALARMA_MINUTOS = "alarmaMinutos";
    
    public static final String VARIABLE_ALARMA = "alarma";
    public static final String VARIABLE_FORMATO = "formato24h";
    
    private int horas;
    private int minutos;
    private int segundos;
    
    private int alarmaHora;
    private int alarmaMinuto;
    
    private boolean alarma;
    private boolean formato24h;
    
    private PropertyChangeSupport cambios;
    private Timer temporizador;
    
        private StyledEditorKit.ForegroundAction colorLetra;

    /**
     * Get the value of colorLetra
     *
     * @return the value of colorLetra
     */
    public StyledEditorKit.ForegroundAction getColorLetra() {
        return colorLetra;
    }

    /**
     * Set the value of colorLetra
     *
     * @param colorLetra new value of colorLetra
     */
    public void setColorLetra(StyledEditorKit.ForegroundAction colorLetra) {
        StyledEditorKit.ForegroundAction oldColor = this.colorLetra;
        this.colorLetra = colorLetra;
        cambios.firePropertyChange("color de la letra", oldColor, colorLetra);
    }

    
    public reloj() {
        //se añaden los valores por defecto
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
        this.formato24h = true;
        this.alarma = false;
        cambios = new PropertyChangeSupport(this);
        this.temporizador = new Timer (1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarTiempo();
                comprobarFormato();
                activarAlarma();
            }
        });
        temporizador.start();
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int newHoras) {
        int oldHoras = this.horas;
        this.horas = newHoras;
        cambios.firePropertyChange(VARIABLE_HORAS, oldHoras, newHoras);
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int newMinutos) {
        int oldMinutos = this.minutos;
        this.minutos = newMinutos;
        cambios.firePropertyChange(VARIABLE_MINUTOS, oldMinutos, newMinutos);
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int newSegundos) {
        int oldSegundos = this.segundos;
        this.segundos = newSegundos;
        cambios.firePropertyChange(VARIABLE_SEGUNDOS, oldSegundos, newSegundos);
    }

    public int getAlarmaHora() {
        return alarmaHora;
    }

    public void setAlarmaHora(int alarmaHora) {
        int oldAlarmaHora = this.alarmaHora;
        this.alarmaHora = alarmaHora;
        cambios.firePropertyChange(VARIABLE_ALARMA_HORA, oldAlarmaHora, alarmaHora);
    }

    public int getAlarmaMinuto() {
        return alarmaMinuto;
    }

    public void setAlarmaMinuto(int alarmaMinuto) {
        int oldAlarmaMinuto = this.alarmaMinuto;
        this.alarmaMinuto = alarmaMinuto;
        cambios.firePropertyChange(VARIABLE_ALARMA_MINUTOS, oldAlarmaMinuto, alarmaMinuto);
    }

    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        boolean oldAlarma = this.alarma;
        this.alarma = alarma;
        cambios.firePropertyChange(VARIABLE_ALARMA, oldAlarma, alarma);
    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        boolean oldFormato = this.formato24h;
        this.formato24h = formato24h;
        cambios.firePropertyChange(VARIABLE_FORMATO, oldFormato, formato24h);
    }
    
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (cambios != null){cambios.addPropertyChangeListener(listener);}
        
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (cambios != null){cambios.removePropertyChangeListener(listener);}
        
    }
    
    //metodos que lancen los eventos
    //metodo para el funcionamiento del reloj, avanza un segundo
    public void aumentarTiempo(){
        this.segundos++;
        if (this.segundos >= 60){
            this.segundos = 0;
            this.minutos++;
            
            if (this.minutos >= 60){
                this.minutos = 0;
                this.horas++;
                if (this.horas >=24){
                    this.horas = 0;
                }
            }
        }
    }
    
    public void comprobarFormato(){
        int h = this.horas;
        String sufijo;
        
        if (this.formato24h){    
            setText(String.format("%02d:%02d:%02d",this.horas,this.minutos,this.segundos));
            repaint();
        }else {
            if (h>12){
                sufijo = "PM";
                h=h-12;
            }else {
                sufijo = "AM";
                if (h == 0) h = 12;
            }
            setText(String.format("%02d:%02d:%02d",h,this.minutos,this.segundos)+""+sufijo);
            repaint();
        }
    }
    
    public void activarAlarma(){
        if(this.alarmaHora == this.horas && this.alarmaMinuto == this.minutos && this.segundos == 0){
            JOptionPane.showMessageDialog(this, "BIP BIP ALARMA", "Está sonando la alarma",JOptionPane.WARNING_MESSAGE);
        }
    }
}
