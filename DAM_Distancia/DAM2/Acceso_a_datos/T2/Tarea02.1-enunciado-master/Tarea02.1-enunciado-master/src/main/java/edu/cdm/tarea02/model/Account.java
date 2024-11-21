
package edu.cdm.tarea02.model;

import java.math.BigDecimal;

/**
 *
 * @author maria
 */
public class Account {
    private Integer accountId;
    private Empleado empleado;
    private BigDecimal montante;

    public Account(Integer accountId, Empleado empleado, BigDecimal montante) {
        this.accountId = accountId;
        this.empleado = empleado;
        this.montante = montante;
    }

    public Account() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public BigDecimal getMontante() {
        return montante;
    }

    public void setMontante(BigDecimal montante) {
        this.montante = montante;
    }
    
    
    
    
}
