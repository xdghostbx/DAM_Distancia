
package edu.cdm.tarea02.model.util.exceptions;

import java.math.BigDecimal;

/**
 *
 * @author maria
 */
public class SaldoInsuficienteException extends Exception {

    private BigDecimal saldoActual;
    private BigDecimal cantidad;

    public SaldoInsuficienteException(String string, BigDecimal saldoActual, BigDecimal cantidad) {
        super(String.format(string, saldoActual, cantidad));
        this.saldoActual = saldoActual;
        this.cantidad = cantidad;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    

}
