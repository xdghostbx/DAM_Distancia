
package edu.cdm.tarea02.model.dao.account;


import java.math.BigDecimal;
import java.sql.SQLException;

import edu.cdm.tarea02.model.Account;
import edu.cdm.tarea02.model.util.IGenericDao;

/**
 *
 * @author mfernandez
 */
public interface IAccountDao extends IGenericDao<Account> {

     int transferir(int accIdOrigen, int accIdDestino, BigDecimal amount) throws SQLException;
     
     Account getAccountByEmpno(int empno);
}
