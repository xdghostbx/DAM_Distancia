package com.example.hibernate.model.servicio;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import com.example.hibernate.model.AccMovement;
import com.example.hibernate.model.Account;
import com.example.hibernate.model.dao.AccMovementDaoHibernate;
import com.example.hibernate.model.dao.AccountDaoHibernate;
import com.example.hibernate.model.dao.IAccMovementDao;
import com.example.hibernate.model.dao.IAccountDao;
import com.example.hibernate.model.util.exceptions.InstanceNotFoundException;

public class AccountServicio implements IAccountServicio {

    private IAccountDao accountDao;
    private IAccMovementDao accmovDao;

    public AccountServicio() {
        this.accountDao = new AccountDaoHibernate();
        this.accmovDao = new AccMovementDaoHibernate();
    }

    @Override
    public AccMovement autoTransferir(Integer accountno, double diferencia) throws InstanceNotFoundException {
        return accmovDao.executarDentroTransaccion(() -> {
            //se busca la cuenta por su numeor
            Account cuenta = accountDao.find(accountno);
            if (cuenta == null) {
                throw new InstanceNotFoundException(accountno, Account.class.getName());
            }
            cuenta.setAmount(cuenta.getAmount().add(BigDecimal.valueOf(diferencia)));
            accountDao.update(cuenta);

            //Se crea el objeto movimiento
            AccMovement movimiento = new AccMovement();
            movimiento.setAccountByAccountDestId(cuenta);
            movimiento.setAccountByAccountOriginId(cuenta);
            movimiento.setAmount(BigDecimal.valueOf(diferencia));
            movimiento.setDatetime(LocalDateTime.now());
            
            //se crea el movimiento nuevo
            accmovDao.create(movimiento);
            return movimiento;

        });
        
    }

    @Override
    public void crear(Account account) {
        accountDao.executarDentroTransaccion(() -> {
            accountDao.create(account);
            //devuelve nulo para poder ejecutarse
            return null;
        });
    }

    @Override
    public void update(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Account> getAccountsByEmpno(Integer empno) {
        return accountDao.executarDentroTransaccion(() -> {
            return accountDao.getAccountsByEmpno(empno);
        });
    }

    @Override
    public void delete(Integer accountno) {
        accountDao.executarDentroTransaccion(() -> {
            accountDao.remove(accountno);
            //devuelve nulo para poder ejecutarse
            return null;
        });
    }

}