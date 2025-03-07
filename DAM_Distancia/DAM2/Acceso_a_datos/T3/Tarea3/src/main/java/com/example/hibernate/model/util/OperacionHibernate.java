package com.example.hibernate.model.util;

@FunctionalInterface
public interface OperacionHibernate<R> {
    public R executar() throws Exception;
}