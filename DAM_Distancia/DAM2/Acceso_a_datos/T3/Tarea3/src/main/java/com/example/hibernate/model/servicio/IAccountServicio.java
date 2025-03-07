package com.example.hibernate.model.servicio;

import java.util.List;

import com.example.hibernate.model.AccMovement;
import com.example.hibernate.model.Account;
import com.example.hibernate.model.util.exceptions.InstanceNotFoundException;

public interface IAccountServicio {

    public AccMovement autoTransferir(Integer accountno, double diferencia) throws InstanceNotFoundException;

    public void crear(Account account);

    public void update(Account account);

    public List<Account> getAccountsByEmpno(Integer empno);

    public void delete(Integer accountno);

}
