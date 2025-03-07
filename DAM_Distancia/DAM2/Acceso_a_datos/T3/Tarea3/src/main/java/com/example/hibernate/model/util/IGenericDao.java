package com.example.hibernate.model.util;

import java.io.Serializable;
import java.util.List;

import com.example.hibernate.model.util.exceptions.InstanceNotFoundException;

/**
 *
 * @author maria
 * @param <E>
 */
public interface IGenericDao<E, PK extends Serializable> {
    // Usamos un tipo genérico para indicar que la interfaz IGenericDao tendrá un
    // parámetro de cualquier tipo (clases del modelo), salvo tipos primitivos
    // https://docs.oracle.com/javase/tutorial/java/generics/types.html
    //Se usa un segundo tipo parametrizado para la clave primaria

    /***
     * Guarda una entidad en el sistema de persistencia
     * 
     * @param entity
     * @return la entidad con la clave primaria asignada
     */
    public void create(E entity);

    /***
     * Busca en el sistema de persistencia una entidad por su clave primaria
     * 
     * @param id
     * @return la entidad si la encuentra
     * @throws InstanceNotFoundException si no encuentra la entidad
     */
    public E find(PK id) throws InstanceNotFoundException;

    /***
     * Comprueba si existe la entidad con ese id como clave primaria
     * 
     * @param id
     * @return true si se ha encontrado, false en caso contrario.
     */
    public boolean exists(PK id);

    /***
     * Elimina una entidad del sistema de persistencia
     * 
     * @param id clave primaria para encontrar la entidad
     * @throws InstanceNotFoundException si no encuentra la entidad
     */
    public void remove(PK id) throws InstanceNotFoundException;

    /**
     * Obtiene una lista de todas las entidades en el sistema persistente
     * 
     * @return
     */
    public List<E> findAll();

    /**
     * Actualiza una entidad del sistema de persistencia
     * @param entidad a actualizar
     * @return entidad actualizada y persistente
     */
    public E update(E entity);

    /**
     * 
     * @param <R> Tipo de Retorno de operacion
     * @param operacion operación que implementa la interfaz OperacionHibernate<R>
     * @return Devuelve un objeto de tipo R genérico
     */
    public <R> R executarDentroTransaccion(OperacionHibernate<R> operacion);
}