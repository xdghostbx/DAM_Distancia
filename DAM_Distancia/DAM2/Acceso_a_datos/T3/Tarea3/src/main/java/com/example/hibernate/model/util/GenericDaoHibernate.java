package com.example.hibernate.model.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.hibernate.model.util.exceptions.InstanceNotFoundException;
import com.example.hibernate.util.HibernateUtil;

/**
 * Implementación xenérica do DAO en Hibernate.
 *
 * @author maria
 */
public class GenericDaoHibernate<E, PK extends Serializable> implements IGenericDao<E, PK> {

    private final Class<E> entityClass;
    private final SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public GenericDaoHibernate() {
        // getClass(): accedemos a la clase de la instancia que extienda esta clase
        // (será ProfesorDaoHibernate u XDaoHibernate)
        // .getGenericSuperclass(): obtenemos el tipo de la clase madre directa:
        // GenericDaoHibernate En el caso de que sea una clase parametrizada (con
        // Generics),devuelve el tipo del parámetro de tipo E: ParameterizedType:
        // https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getGenericSuperclass--
        // .getActualTypeArguments(): devuelve un array de los tipos de los argumentos
        // que se le pasan al tipo parametrizado <E, PK>
        // finalmente obtenemos el nombre del tipo parametrizado: <E> que será
        // Profesor
        this.entityClass = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];

        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 
     * @param <R>       Tipo de retorno da operación.
     * @param operacion Función que recibe a sesión e devolve un resultado.
     *                  Personalizouse para poder lanzar unha Exception
     * @return O resultado da operación.
     * 
     */

    public <R> R executarDentroTransaccion(OperacionHibernate<R> operacion) {
        Transaction tx = null;
        R resultado = null;
        try {
            Session session = getSession();
            tx = session.beginTransaction();
            resultado = operacion.executar();
            tx.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException("Erro ao executar a operación en Hibernate", ex); // Convértese en unchecked
                                                                                         // exception
        }
        return resultado;
    }

    @Override
    public void create(E entity) {
        Session session = getSession();
        session.persist(entity);
    }

    @Override
    public E update(E entity) {
        Session session = getSession();
        return session.merge(entity);
    }

    @Override
    public boolean exists(PK id) {
        Session session = getSession();
        return session.get(entityClass, id) != null;
    }

    @Override
    public E find(PK id) throws InstanceNotFoundException {
        Session session = getSession();
        E entity = session.get(entityClass, id);
        if (entity == null) {
            throw new InstanceNotFoundException(id, entityClass.getName());
        }
        return entity;
    }

    @Override
    public void remove(PK id) throws InstanceNotFoundException {
        Session session = getSession();
        E entity = session.get(entityClass, id);
        if (entity == null) {
            throw new InstanceNotFoundException(id, entityClass.getName());
        }
        session.remove(entity);
    }

    @Override
    public List<E> findAll() {
        Session session = getSession();
        return session.createSelectionQuery("SELECT c FROM " + entityClass.getName() + " c", entityClass)
                .getResultList();
    }
}
