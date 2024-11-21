
package edu.cdm.tarea02.services.empleado;

import java.math.BigDecimal;
import java.sql.SQLException;

import edu.cdm.tarea02.model.Account;
import edu.cdm.tarea02.model.AccountMovement;


import edu.cdm.tarea02.model.dao.account.AccountDaoMySQL;
import edu.cdm.tarea02.model.dao.account.AccountDaoSQLServer;
import edu.cdm.tarea02.model.dao.account.IAccountDao;
import edu.cdm.tarea02.model.dao.accountMovement.AccountMovementDao;
import edu.cdm.tarea02.model.dao.accountMovement.IAccountMovementDao;
import edu.cdm.tarea02.model.util.db.DBCPDataSourceUtil;
import edu.cdm.tarea02.model.util.db.DBCPDataSourceUtil.DB_SUPPORTED_TYPES;
import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;
import edu.cdm.tarea02.model.util.exceptions.SaldoInsuficienteException;

/**
 *
 * @author maria
 */
public class EmpleadoService implements IEmpleadoServicio {

    private IAccountDao accountDao;
    private IAccountMovementDao accountMovDao;

    public EmpleadoService() throws Exception {

        DB_SUPPORTED_TYPES dbType = DBCPDataSourceUtil.getDBType();
        switch (dbType) {
            case DB_SUPPORTED_TYPES.MYSQL:
                this.accountDao = new AccountDaoMySQL();
                break;

            case DB_SUPPORTED_TYPES.SQLSERVER:
                this.accountDao = new AccountDaoSQLServer();
                break;

            default:
                break;
        }

        this.accountMovDao = new AccountMovementDao();

    }

    @Override
    public AccountMovement transferir(int empnoOrigen, int empnoDestino, BigDecimal cantidad)
            throws SaldoInsuficienteException, InstanceNotFoundException, UnsupportedOperationException, SQLException {
        int accMovId = -1;
        AccountMovement accMovement = null;
        // Si la cantidad a transferir es >0
        if (cantidad.compareTo(BigDecimal.ZERO) == 1) {
            Account cuentaOrigen = accountDao.getAccountByEmpno(empnoOrigen);

            if (cuentaOrigen != null) {

                if (cuentaOrigen.getMontante().compareTo(cantidad) >= 0) {
                    Account cuentaDestino = accountDao.getAccountByEmpno(empnoDestino);

                    if (cuentaDestino != null) {

                        accMovId = accountDao.transferir(cuentaOrigen.getAccountId(), cuentaDestino.getAccountId(),
                                cantidad);
                        if (accMovId != -1) {
                            accMovement = accountMovDao.read(accMovId);
                        }
                    } else {
                        throw new UnsupportedOperationException(
                                "El empleado " + empnoDestino + " no tiene una cuenta asociada");
                    }

                } else {
                    throw new SaldoInsuficienteException(
                            "No hay suficiente saldo en la cuenta: Cantidad actual: %.2f Cantidad a transferir: %.2f",
                            cuentaOrigen.getMontante(), cantidad);
                }
            } else {
                throw new UnsupportedOperationException("El empleado " + empnoOrigen + " no tiene una cuenta asociada");
            }
        } else {
            throw new UnsupportedOperationException("Las cantidades a transferir deben ser positivas");
        }

        return accMovement;
    }
}
