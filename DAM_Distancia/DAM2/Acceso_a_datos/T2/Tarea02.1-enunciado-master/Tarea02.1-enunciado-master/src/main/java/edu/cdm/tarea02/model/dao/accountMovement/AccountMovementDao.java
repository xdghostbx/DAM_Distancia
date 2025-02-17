package edu.cdm.tarea02.model.dao.accountMovement;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


import javax.sql.DataSource;

import edu.cdm.tarea02.model.Account;
import edu.cdm.tarea02.model.AccountMovement;
import edu.cdm.tarea02.model.util.AbstractGenericDao;
import edu.cdm.tarea02.model.util.db.DBCPDataSourceUtil;
import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;

public class AccountMovementDao extends AbstractGenericDao<AccountMovement> implements IAccountMovementDao {

    protected DataSource dataSource;
    public AccountMovementDao() {
        this.dataSource = DBCPDataSourceUtil.getDataSource();
    }
    
    @Override
    public AccountMovement create(AccountMovement entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    /*
     * Apartado 2
     * Crear la clase AccountMovementDao que herede AbstractGenericDao y  implemente la interfaz IAccountMovementDao.
     * Tambien implementa el metodo read
     */
    @Override
    public AccountMovement read(int id) throws InstanceNotFoundException {
        int accountMvID;
        int accountOrgID;
        int accountDstID;
        BigDecimal amount;
        LocalDate date;

        AccountMovement accountMovement = null;

        try (
            Connection conexion = this.dataSource.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(
                "SELECT ACCOUNT_MOV_ID, ACCOUNT_ORIGIN_ID"
                +", ACCOUNT_DEST_ID, AMOUNT, DATETIME"+ 
                " FROM ACC_MOVEMENT WHERE ACCOUNT_MOV_ID = ?"
            );
        ){
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                accountMvID = rs.getInt("ACCOUNT_MOV_ID");
                accountOrgID = rs.getInt("ACCOUNT_ORIGIN_ID");
                accountDstID = rs.getInt("ACCOUNT_DEST_ID");
                amount = rs.getBigDecimal("AMOUNT");
                date = rs.getDate("DATETIME").toLocalDate();

                Account origen = new Account ();
                origen.setAccountId(accountOrgID);

                Account destino = new Account ();
                destino.setAccountId(accountDstID);

                accountMovement = new AccountMovement(accountMvID, origen, destino, amount, date);
            }

        } catch (SQLException ex) {
            System.out.println("Error al leer el movimiento de cuenta"); 
        } 
        return accountMovement;
    }

    @Override
    public boolean update(AccountMovement entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int transferir (int accIdOrigen, int accIdDestino, BigDecimal amount){
        int id = -1; //devuelve -1 si no se ha podido realizar la transferencia
        LocalDate date = LocalDate.now();
    
        try (
            Connection conexion = this.dataSource.getConnection();
            PreparedStatement pstmt = conexion.prepareStatement(
                "INSERT INTO ACC_MOVEMENT (ACCOUNT_ORIGIN_ID, ACCOUNT_DEST_ID, AMOUNT, DATETIME) VALUES (?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS
            );
        ) {
            conexion.setAutoCommit(false);
            pstmt.setInt(1, accIdOrigen);
            pstmt.setInt(2, accIdDestino);
            pstmt.setBigDecimal(3, amount);
            pstmt.setDate(4, java.sql.Date.valueOf(date));
            pstmt.executeUpdate();
            ResultSet clavesResultado = pstmt.getGeneratedKeys();
            if (clavesResultado.next()) {
                id = clavesResultado.getInt(1);
            }

            //bloque de codigo para actualizar la cuenta origen
            try (
                PreparedStatement updateOrigen = conexion.prepareStatement(
                    "UPDATE ACCOUNT SET AMOUNT = AMOUNT - ? WHERE EMPNO = ?"
                );
            ) {
                updateOrigen.setBigDecimal(1, amount);
                updateOrigen.setInt(2, accIdOrigen);
                updateOrigen.executeUpdate();
    
                System.out.println("Cuenta origen actualizada");
            }

            //bloque de codigo para actualizar la cuenta destino
            try (
                PreparedStatement updateDestino = conexion.prepareStatement(
                    "UPDATE ACCOUNT SET AMOUNT = AMOUNT + ? WHERE EMPNO = ?"
                );
            ) {
                updateDestino.setBigDecimal(1, amount);
                updateDestino.setInt(2, accIdDestino);
                updateDestino.executeUpdate();
                
                System.out.println("Cuenta destino actualizada");
            }
            conexion.commit();

        } catch (SQLException ex) {
            System.out.println("Error al transferir el movimiento de cuenta");
            try (Connection conexion = this.dataSource.getConnection())
            {
                conexion.rollback();
                System.out.println("Transaccion revertida");
            } catch (SQLException e) {
                System.out.println("Error al hacer rollback");
            }
        }
        return id;
    }

}
