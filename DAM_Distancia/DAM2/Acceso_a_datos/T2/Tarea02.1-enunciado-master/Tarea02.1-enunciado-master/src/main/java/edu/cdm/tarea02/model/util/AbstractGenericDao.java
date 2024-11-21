
package edu.cdm.tarea02.model.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @author maria
 */
public abstract class AbstractGenericDao<E> implements IGenericDao<E> {

    // getClass(): accedemos a la clase de la instancia que extienda esta clase
    // (será DepartamentoSQLServerDao u XSQLServerDao)
    // .getGenericSuperclass(): obtenemos el tipo de la clase madre directa:
    // AbstractGenericDao En el caso de que sea una clase parametrizada (con
    // Generics),devuelve el tipo del parámetro de tipo E: ParameterizedType:
    // https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html#getGenericSuperclass--
    // .getActualTypeArguments(): devuelve un array de los tipos de los argumentos
    // que se le pasan al tipo parametrizado (podrían ser más de uno, aunque en este
    // caso el tipo es uno solo <E>)
    // finalmente obtenemos el nombre del tipo parametrizado: <E> que será
    // Departamento (u otro cuando se implemente)

    //Esto no funciona cuando hay jerarquía de herencia de más de un nivel desde AbstractGenericDao
    // final String entityClass = ((Class<E>) ((ParameterizedType)
    // getClass().getGenericSuperclass())
    // .getActualTypeArguments()[0]).getName();

    private String entityClass = "";

    public String getEntityClass() {
        return this.entityClass;
    }

    public AbstractGenericDao() {
    
          this.entityClass = ((Class<E>) ((ParameterizedType)  getGenericSuperClassRecursive(getClass())).getActualTypeArguments()[0]).getName();

          //System.out.println("entity class es: " + entityClass);

    }

    private static Type getGenericSuperClassRecursive(Class<?> clase) {
        Type type = clase.getGenericSuperclass();
        //Si se extiende directamente de AbstractGenericDao, se recoge el tipo parametrizado
        if (type instanceof ParameterizedType)
            return type;
        else
        //si no se asciende en la jerarquía hasta que se encuentre el tipo parametrizado de AbstractGenericDao
            return getGenericSuperClassRecursive(clase.getSuperclass());
    }

}
