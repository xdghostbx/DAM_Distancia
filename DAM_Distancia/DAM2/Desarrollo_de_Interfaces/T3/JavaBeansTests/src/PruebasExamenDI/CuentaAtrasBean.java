/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PruebasExamenDI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CuentaAtrasBean extends JLabel implements Serializable {

    private int tiempo;
    private final Timer temporizador;
    private final PropertyChangeSupport cambios;
    private boolean activo;
    private String cabecera;
    private String cuerpo;

    // 🔹 Constructor con valor por defecto de 5 segundos
    public CuentaAtrasBean() {
        
        super("Tiempo restante: 5"); // Inicializamos el texto en el JLabel
        this.tiempo = 5;
        this.cambios = new PropertyChangeSupport(this);
        this.activo = false;
        this.cabecera ="";
        this.cuerpo="";
        // Inicializamos el Timer con 1000 ms (1 segundo)
        this.temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isActivo()) {
                    reducirTiempo();
                }else
                    detener();
            }
        });
        //this.temporizador.start();
    }

    // 🔹 Getter para obtener el tiempo actual
    public int getTiempo() {
        return tiempo;
    }

    // 🔹 Setter para modificar el tiempo
    public void setTiempo(int nuevoTiempo) {
        int tiempoAnterior = this.tiempo;
        this.tiempo = nuevoTiempo;
        setText("Tiempo restante: " + this.tiempo); // 🔹 Actualiza el texto en el JLabel
        repaint();
        cambios.firePropertyChange("tiempo", tiempoAnterior, nuevoTiempo);
    }

    // 🔹 Método para iniciar la cuenta atrás
    public void iniciar() {
        temporizador.start();
    }

    // 🔹 Método para detener la cuenta atrás
    public void detener() {
        temporizador.stop();
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean nuevoActivo) {
        boolean viejoActivo = this.activo;
        this.activo = nuevoActivo;
        cambios.firePropertyChange("activo", viejoActivo, nuevoActivo);
        
        if (this.activo) iniciar();
        else detener();
    }
    
    // 🔹 Método que reduce el tiempo cada segundo
    private void reducirTiempo() {
        if (tiempo > 0) {
            setTiempo(tiempo - 1);
        }

        if (tiempo == 0) {
            temporizador.stop();
            mostrarAlarma(); // 🔹 Llamamos a la alarma cuando llegue a 0
        }
    }

    // 🔹 Muestra una ventana con una alarma cuando el tiempo llega a 0
    private void mostrarAlarma() {
        JOptionPane.showMessageDialog(
            this, 
            cabecera ,
            cuerpo, 
            JOptionPane.WARNING_MESSAGE
        );
    }

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String nuevaCabecera) {
        String viejaCabecera = this.cabecera;
        this.cabecera = nuevaCabecera;
        cambios.firePropertyChange("cabecera", viejaCabecera, nuevaCabecera);
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String nuevoCuerpo) {
        String viejoCuerpo = this.cuerpo;
        this.cuerpo = nuevoCuerpo;
        cambios.firePropertyChange("cuerpo", viejoCuerpo, nuevoCuerpo);
    }
    
    
    // 🔹 Métodos para agregar y eliminar PropertyChangeListeners
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
