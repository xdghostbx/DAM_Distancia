
package edu.cdm.tarea02.model.dao.account;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import edu.cdm.tarea02.model.Account;
import edu.cdm.tarea02.model.Empleado;
import edu.cdm.tarea02.model.util.AbstractGenericDao;
import edu.cdm.tarea02.model.util.db.DBCPDataSourceUtil;
import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;

/**
 *
 * @author maria
 */
public abstract class AccountDao
        extends AbstractGenericDao<Account> implements IAccountDao {

    protected DataSource dataSource;

    public AccountDao() {
        this.dataSource = DBCPDataSourceUtil.getDataSource();
    }

    @Override
    public Account create(Account entity) {

        try (
                 Connection conexion = this.dataSource.getConnection();  PreparedStatement pstmt = conexion.prepareStatement(
                "INSERT INTO  ACCOUNT \n"
                + "           ( EMPNO \n"
                + "           , AMOUNT )\n"
                + "     VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS
        );) {

            pstmt.setInt(1, entity.getEmpleado().getEmpleadoId());
            pstmt.setBigDecimal(2, entity.getMontante());

            // Devolverá 0 para las sentencias SQL que no devuelven nada o el número de filas afectadas
            pstmt.executeUpdate();

            ResultSet clavesResultado = pstmt.getGeneratedKeys();

            if (clavesResultado.next()) {
                int accountId = clavesResultado.getInt(1);
                entity.setAccountId(accountId);
            } else {
                entity = null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
            entity = null;
        }
        return entity;
    }

    @Override
    public Account read(int id) throws InstanceNotFoundException {

        int accountNo;
        int empno;
        BigDecimal amount;
        int contador;
        Account cuenta = null;

        try (
                 Connection conexion = this.dataSource.getConnection();  PreparedStatement sentencia
                = conexion.prepareStatement("SELECT   ACCOUNTNO \n"
                        + "      , EMPNO \n"
                        + "      , AMOUNT \n"
                        + "  FROM  ACCOUNT "
                        + "WHERE ACCOUNTNO=?");) {
            sentencia.setInt(1, id);

            ResultSet result = sentencia.executeQuery();
            if (result.next()) {
                contador = 0;

                accountNo = result.getInt(++contador);
                empno = result.getInt(++contador);
                amount = result.getBigDecimal(++contador);

                Empleado empleado = new Empleado();
                empleado.setEmpleadoId(empno);
                cuenta = new Account(accountNo, empleado, amount);

            } else {
                throw new InstanceNotFoundException(id, getEntityClass());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        }
        return cuenta;
    }

    @Override
    public boolean update(Account entity) {
        boolean actualizado = false;
        //no vamos a actualizar el empledo
        try (
                 Connection conexion = this.dataSource.getConnection();  PreparedStatement pstmt = conexion.prepareStatement(
                "UPDATE    . ACCOUNT \n"
                + "   SET  AMOUNT  = ? \n"
                + " WHERE ACCOUNTNO = ?")) {

            pstmt.setBigDecimal(1, entity.getMontante());
            pstmt.setInt(2, entity.getAccountId());

            int result = pstmt.executeUpdate();
            actualizado = (result == 1);

            // Devolverá 0 para las sentencias SQL que no devuelven nada o el número de filas afectadas
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        }
        return actualizado;
    }

    @Override
    public boolean delete(int id) {
        int result = 0;
        try (
                 Connection conexion = this.dataSource.getConnection();  PreparedStatement pstmt = conexion.prepareStatement("DELETE FROM ACCOUNT WHERE ACCOUNTNO=?");) {

            pstmt.setInt(1, id);

            result = pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        }
        return (result == 1);
    }

    @Override
    public abstract int transferir(int accIdOrigen, int accIdDestino, BigDecimal amount) throws SQLException;

    /*
     * Apartado 1
     * Método que devuelve una cuenta a partir del número de empleado
     * 
     * Deve devolver un objeto de tipo Account 
     */
    @Override
    public Account getAccountByEmpno(int empno){
        //declaro las variables de cuenta para poder cargarlas en la consulta
        int accountNo;
        int empno2;
        BigDecimal amount;
        Account cuenta = null;
        try(
            Connection conexion = this.dataSource.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement("SELECT * FROM ACCOUNT WHERE EMPNO = ?");
        ){
            
            pstmt.setInt(1, empno);
            ResultSet result = pstmt.executeQuery();
            if (result.next()){
                accountNo = result.getInt("ACCOUNTNO");
                empno2 = result.getInt("EMPNO");
                amount = result.getBigDecimal("AMOUNT");

                Empleado empleado = new Empleado();
                empleado.setEmpleadoId(empno2);

                cuenta = new Account(accountNo, empleado, amount);
            }
        } catch (SQLException e){
            System.out.println("Error al buscar la cuenta por empleado");
        }
        return cuenta;
    }   

}
