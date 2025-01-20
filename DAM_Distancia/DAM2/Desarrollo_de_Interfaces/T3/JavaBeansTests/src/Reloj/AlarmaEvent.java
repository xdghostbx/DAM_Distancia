/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reloj;

import java.util.EventObject;

/**
 *
 * @author USER
 */
public class AlarmaEvent extends EventObject {
    private final String mensaje;

    public AlarmaEvent(Object source, String mensaje) {
        super(source);
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

