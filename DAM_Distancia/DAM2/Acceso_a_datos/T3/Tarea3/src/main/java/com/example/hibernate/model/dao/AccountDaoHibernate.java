package com.example.hibernate.model.dao;

import java.util.List;

import com.example.hibernate.model.Account;
import com.example.hibernate.model.util.GenericDaoHibernate;

public class AccountDaoHibernate  extends GenericDaoHibernate<Account, Integer> implements IAccountDao {

    public AccountDaoHibernate() {
        super();
    }

    @Override
    public List<Account> getAccountsByEmpno(Integer empno) {
        String hql = "from Account a where a.emp.empno = :empno";
        return getSession()
                .createQuery(hql, Account.class)
                .setParameter("empno", empno)
                .list();
    }

}
