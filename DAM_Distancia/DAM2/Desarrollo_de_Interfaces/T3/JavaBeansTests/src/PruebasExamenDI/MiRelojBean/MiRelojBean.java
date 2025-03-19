/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebasExamenDI.MiRelojBean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class MiRelojBean extends JLabel implements Serializable {
    private boolean f24h;
    private boolean alarma;
    private int horas;
    private int minutos;
    private int segundos;
    private int hAlarma;
    private int mAlarma;
    private final PropertyChangeSupport cambios;
    private final Timer temporizador;
    private LocalDateTime time;
    public String h,m,s;
    
    public MiRelojBean() {
        cambios = new PropertyChangeSupport(this);
        this.f24h = true;
        this.alarma = false;
        this.hAlarma = 0;
        this.mAlarma = 0;
        this.time = LocalDateTime.now();
        this.temporizador = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarTiempo();
                repaint();
            }
        });
        temporizador.start();
    }
    
    public void aumentarTiempo() {
        time = LocalDateTime.now();
        horas = time.getHour();
        minutos = time.getMinute();
        segundos = time.getSecond();
        h=""+horas;
        m=""+minutos;
        s=""+segundos;
        if (minutos<10){
            m="0"+minutos;
        }
        if(segundos<10){
            s="0"+segundos;
        }
        if (f24h){
            setText(h+":"+m+":"+s);
        }else if (!f24h){
            if(horas>12){
                horas= horas-12;
                h=""+horas;
            }
            setText(h+":"+m+":"+s);
        }
        
    }

    public boolean isF24h() {
        return f24h;
    }

    public void setF24h(boolean nuevof24h) {
        boolean viejof24h = this.f24h;
        this.f24h = nuevof24h;
        cambios.firePropertyChange("Formato 24h/12h", viejof24h, nuevof24h);
    }

    public boolean isAlarma() {
        return alarma;
    }

    public void setAlarma(boolean nuevaAlarma) {
        boolean viejaAlarma = this.alarma;
        this.alarma = nuevaAlarma;
        cambios.firePropertyChange("Activar alarma", viejaAlarma, nuevaAlarma);
        if ((Integer.valueOf(h) == hAlarma)&&(Integer.valueOf(m)==mAlarma)){
            sonarAlarma();
        }
    }

    public int gethAlarma() {
        return hAlarma;
    }

    public void sethAlarma(int nhAlarma) {
        int vhAlarma = this.hAlarma;
        this.hAlarma = nhAlarma;
        cambios.firePropertyChange("Hora para la alarma", vhAlarma, nhAlarma);
    }

    public int getmAlarma() {
        return mAlarma;
    }

    public void setmAlarma(int nmAlarma) {
        int vmAlarma = this.mAlarma;
        this.mAlarma = nmAlarma;
        cambios.firePropertyChange("Minutos para la alarma", vmAlarma, nmAlarma);
    }
    
    public void sonarAlarma(){
        JOptionPane.showMessageDialog(this, "Alarma!", "bip bip", JOptionPane.WARNING_MESSAGE);
    }
    
     public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (cambios != null) {  // 🔹 Se evita el error de `null`
            cambios.addPropertyChangeListener(listener);
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (cambios != null) {  // 🔹 Se evita el error de `null`
            cambios.removePropertyChangeListener(listener);
        }
    }
}
