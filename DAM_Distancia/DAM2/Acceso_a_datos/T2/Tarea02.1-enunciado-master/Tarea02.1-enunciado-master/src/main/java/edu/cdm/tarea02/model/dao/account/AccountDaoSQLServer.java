
package edu.cdm.tarea02.model.dao.account;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import edu.cdm.tarea02.model.Account;
import edu.cdm.tarea02.model.Empleado;



/**
 *
 * @author maria
 */
public class AccountDaoSQLServer
        extends AccountDao  {

    

    public AccountDaoSQLServer() {
      super();
    }

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

   @Override
    public int transferir(int accIdOrigen, int accIdDestino, BigDecimal amount) {
        int id = -1; // Devuelve -1 si no se ha podido realizar la transferencia
        LocalDateTime date = LocalDateTime.now();
        Connection conexion = null;

        try {
            conexion = this.dataSource.getConnection();
            conexion.setAutoCommit(false);

            //Actualizar la cuenta origen
            try (PreparedStatement updateOrigen = conexion.prepareStatement(
                    "UPDATE ACCOUNT SET AMOUNT = (AMOUNT - ?) WHERE ACCOUNTNO = ?")) {

                updateOrigen.setBigDecimal(1, amount);
                updateOrigen.setInt(2, accIdOrigen);
                updateOrigen.executeUpdate();
            }

            
            //Actualizar la cuenta destino
            try (PreparedStatement updateDestino = conexion.prepareStatement(
                    "UPDATE ACCOUNT SET AMOUNT = (AMOUNT + ?) WHERE ACCOUNTNO = ?")) {
                    

                updateDestino.setBigDecimal(1, amount);
                updateDestino.setInt(2, accIdDestino);
                
                updateDestino.executeUpdate();
            }

            // Insertar el movimiento en la tabla ACCOUNT_MOVEMENT
            try (PreparedStatement pstmt = conexion.prepareStatement(
                    "INSERT INTO ACC_MOVEMENT (ACCOUNT_ORIGIN_ID, ACCOUNT_DEST_ID, AMOUNT, DATETIME) VALUES (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setInt(1, accIdOrigen);
                pstmt.setInt(2, accIdDestino);
                pstmt.setBigDecimal(3, amount);
                pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(date));

                pstmt.executeUpdate();

                try (ResultSet clavesResultado = pstmt.getGeneratedKeys()) {
                    if (clavesResultado.next()) {
                        id = clavesResultado.getInt(1);
                    }
                }
            }


            // Confirmar transacción
            conexion.commit();
            System.out.println("Transacción completada con éxito");

        } catch (SQLException ex) {
            System.out.println("Error al transferir el movimiento de cuenta: " + ex.getMessage());
            if (conexion != null) {
                try {
                    conexion.rollback();
                    System.out.println("Transacción revertida");
                } catch (SQLException e) {
                    System.out.println("Error al hacer rollback: " + e.getMessage());
                }
            }
        } finally {
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar la conexión: " + ex.getMessage());
                }
            }
        }

        return id;
    }

}
