package org.hibernate.tutorial;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

    private static final SessionFactory sessionFactory;
    /**
	 * El bloque static es un bloque de instrucción dentro de una clase Java que se
	 * ejecuta cuando una clase se carga por primera vez en la JVM. Inicializa
	 * la variable SessionFactory de tipo static para que solo haya una instancia
	 * para todas las consultas en toda la aplicación Seguimos el patrón Singleton:
	 * https://es.wikipedia.org/wiki/Singleton
	 */

    static {
        try {

            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
