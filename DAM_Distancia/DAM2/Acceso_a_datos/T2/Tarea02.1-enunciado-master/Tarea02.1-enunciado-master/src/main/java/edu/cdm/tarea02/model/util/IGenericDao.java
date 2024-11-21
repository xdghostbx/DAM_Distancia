
package edu.cdm.tarea02.model.util;

import edu.cdm.tarea02.model.util.exceptions.InstanceNotFoundException;

/**
 *
 * @author maria
 * @param <E>
 */
public interface IGenericDao<E> {
//Usamos un tipo genérico para indicar que la interfaz IGenericDao tendrá un parámetro de cualquier tipo (clases del modelo), salvo tipos primitivos    
    //https://docs.oracle.com/javase/tutorial/java/generics/types.html
    

/***
 * Guarda una entidad en el sistema de persistencia 
 * @param entity
 * @return la entidad  con la clave primaria asignada
 */
    public E create(E entity);

    /***
     * Busca en el sistema de persistencia una entidad por su clave primaria
     * @param id
     * @return la entidad si la encuentra
     * @throws InstanceNotFoundException si no encuentra la entidad
     */
    public E read(int id) throws InstanceNotFoundException;

    
    /***
     * Actualiza los datos de una entidad
     * @param entity entidad con los nuevos datos
     * @return true si se ha actualizado correctamente, false en caso contrario.
     */
    public boolean update(E entity);

    
    /***
     * Elimina una entidad del sistema de persistencia
     * @param id clave primaria para encontrar la entidad
     * @return  true si se ha eliminado correctamente, false en caso contrario.
     */
    public boolean delete(int id);

}
