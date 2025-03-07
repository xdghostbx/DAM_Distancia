package com.example.hibernate.model.dao;

import java.util.List;

import com.example.hibernate.model.Account;
import com.example.hibernate.model.util.IGenericDao;

public interface IAccountDao extends IGenericDao<Account, Integer> {
    public List<Account> getAccountsByEmpno(Integer empno);
}
