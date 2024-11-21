
package edu.cdm.tarea02.model.dao.accountMovement;

import java.math.BigDecimal;
import java.sql.SQLException;

import edu.cdm.tarea02.model.AccountMovement;
import edu.cdm.tarea02.model.util.IGenericDao;

/**
 *
 * @author maria
 */
public interface IAccountMovementDao extends IGenericDao<AccountMovement> {
    int transferir(int accIdOrigen, int accIdDestino, BigDecimal amount) throws SQLException;
}
