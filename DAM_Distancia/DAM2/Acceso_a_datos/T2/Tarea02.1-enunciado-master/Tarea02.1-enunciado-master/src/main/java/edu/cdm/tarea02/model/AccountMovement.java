
package edu.cdm.tarea02.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author maria
 */
public class AccountMovement {
    private Account cuentaOrigen;
    private Account cuentaDestino;
    private Integer id;
    private LocalDate fecha;
    private BigDecimal cantidad =BigDecimal.ZERO;

    public AccountMovement(Integer id, Account cuentaOrigen, Account cuentaDestino,BigDecimal cantidad,  LocalDate fecha) {
        this.id = id;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public AccountMovement() {
    }

    public Account getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Account cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Account getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Account cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "AccountMovement{" + "cuentaOrigen=" + cuentaOrigen + ", cuentaDestino=" + cuentaDestino + ", id=" + id + ", fecha=" + fecha + ", cantidad=" + cantidad + '}';
    }
    
    
}
