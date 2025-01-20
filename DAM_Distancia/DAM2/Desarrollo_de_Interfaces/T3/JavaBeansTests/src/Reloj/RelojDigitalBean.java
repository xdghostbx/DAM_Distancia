/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package Reloj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author USER
 */
public class RelojDigitalBean extends JLabel implements Serializable, ActionListener {
    
    private boolean formato24h;
    private boolean activarAlarma;
    private int horaAlarma;
    private int minutoAlarma;
    private String textoAlarma;
    private final Timer timer;
    private PropertyChangeSupport propertySupport;
    private AlarmaListener alarmaListener;
    
    public static final String PROP_FORMATO = "formato24h";
    public static final String PROP_ALARMA = "activarAlarma";
    public static final String PROP_ALARMAHORA = "horaAlarma";
    public static final String PROP_ALARMAMINUTO = "minutoAlarma";
    public static final String PROP_MENSAJE = "textoAlarma";


    public RelojDigitalBean() {
        formato24h = true;
        activarAlarma = false;
        horaAlarma = 0;
        minutoAlarma = 0;
        textoAlarma = "Bip Bip";
        
        timer = new Timer(1000,this);
        timer.start();
        
        propertySupport = new PropertyChangeSupport(this);
        actualizarHora();
    }

    public boolean isFormato24h() {
        return formato24h;
    }

    public void setFormato24h(boolean formato24h) {
        boolean oldFormato24h = this.formato24h;
        this.formato24h = formato24h;
        propertySupport.firePropertyChange(PROP_FORMATO, oldFormato24h, formato24h);
    }

    public boolean isActivarAlarma() {
        return activarAlarma;
    }

    public void setActivarAlarma(boolean activarAlarma) {
        boolean oldActivarAlarma = this.activarAlarma;
        this.activarAlarma = activarAlarma;
        propertySupport.firePropertyChange(PROP_ALARMA, oldActivarAlarma, activarAlarma);
    }

    public int getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(int horaAlarma) {
        int oldHoraAlarma = horaAlarma;
        this.horaAlarma = horaAlarma;
        propertySupport.firePropertyChange(PROP_ALARMAHORA, oldHoraAlarma, horaAlarma);
    }

    public int getMinutoAlarma() {
        return minutoAlarma;
    }

    public void setMinutoAlarma(int minutoAlarma) {
        int oldMinutoAlarma = minutoAlarma;
        this.minutoAlarma = minutoAlarma;
        propertySupport.firePropertyChange(PROP_ALARMAMINUTO, oldMinutoAlarma, minutoAlarma);
    }

    public String getTextoAlarma() {
        return textoAlarma;
    }

    public void setTextoAlarma(String textoAlarma) {
        String oldTextoAlarma = this.textoAlarma;
        this.textoAlarma = textoAlarma;
        propertySupport.firePropertyChange(PROP_MENSAJE,oldTextoAlarma,textoAlarma);
    }

    public void actionPerformed(ActionEvent e) {
        actualizarHora();
    }

    private void actualizarHora(){
        LocalTime now = LocalTime.now();
        DateTimeFormatter formateador;
        
        if (formato24h) {
            formateador = DateTimeFormatter.ofPattern("HH:mm:ss");
        }else {
            formateador = DateTimeFormatter.ofPattern("hh:mm:ss");
        }
        
        setText(now.format(formateador));
        comprobarAlarma(now);
    }
    
    private void comprobarAlarma (LocalTime now) {
        if (activarAlarma){
            if(now.getHour()== horaAlarma && now.getMinute() == minutoAlarma){
                if (alarmaListener != null) {
                    alarmaListener.capturarAlarma(new AlarmaEvent(this, textoAlarma));
                }
                
                javax.swing.JOptionPane.showMessageDialog(this, "BIP BIP");
                activarAlarma = false;
            }
        }
        
        
    }
    
    public void addAlarmaListener (AlarmaListener listener) {
        this.alarmaListener = listener;
    }
    
    public void removeAlarmaListener (AlarmaListener listener){
        this.alarmaListener = null;
    }
    
    public interface AlarmaListener extends EventListener {
        void capturarAlarma (AlarmaEvent event);
    }
}
