
package edu.cdm.tarea02.services.empleado;


import java.math.BigDecimal;
import java.sql.SQLException;

import edu.cdm.tarea02.model.AccountMovement;

import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;
import edu.cdm.tarea02.model.util.exceptions.SaldoInsuficienteException;

/**
 *
 * @author maria
 */
public interface IEmpleadoServicio {
    

    
    public AccountMovement transferir(int empnoOrigen, int empnoDestino, BigDecimal cantidad) throws SaldoInsuficienteException, InstanceNotFoundException, 
    UnsupportedOperationException, SQLException;
    
}
