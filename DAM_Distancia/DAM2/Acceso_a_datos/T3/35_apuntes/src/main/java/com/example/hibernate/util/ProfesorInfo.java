package com.example.hibernate.util;

import java.io.Serializable;

public class ProfesorInfo implements Serializable {
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ProfesorInfo(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public ProfesorInfo() {
    }


    
}
