package com.example.hibernate.model.dao;

import com.example.hibernate.model.Empleado;
import com.example.hibernate.model.util.GenericDaoHibernate;

public class EmpleadoDaoHibernate extends GenericDaoHibernate<Empleado, Integer> implements IEmpleadoDao {

    public EmpleadoDaoHibernate() {
        super();
    }

}
