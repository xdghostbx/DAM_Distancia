package com.example.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.example.hibernate.model.Cicloformativo;
import com.example.hibernate.model.Comunidadautonoma;
import com.example.hibernate.model.Direccion;
import com.example.hibernate.model.Modulo;
import com.example.hibernate.model.Profesor;
import com.example.hibernate.model.Provincia;
import com.example.hibernate.model.Tiposbasicos;

public class HibernateUtil {

    private static HibernateUtil instance;
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    // Private constructor to prevent external instantiation
    private HibernateUtil() {
        try {
            // Automatically reads hibernate.properties or hibernate.cfg.xml from classpath
            serviceRegistry = 
            new StandardServiceRegistryBuilder()
						.build();

            // Build SessionFactory using the service registry
            sessionFactory = new org.hibernate.boot.MetadataSources(serviceRegistry)
                  .addAnnotatedClass(Profesor.class)
                  .addAnnotatedClass(Tiposbasicos.class)
                  .addAnnotatedClass(Provincia.class)
                  .addAnnotatedClass(Modulo.class)
                  .addAnnotatedClass(Comunidadautonoma.class)
                  .addAnnotatedClass(Direccion.class)
                  .addAnnotatedClass(Cicloformativo.class)
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("Failed to create SessionFactory: " + ex);
        }
    }

    // Singleton accessor method
    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    // Get the SessionFactory
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Shutdown Hibernate and clean up resources
    public static void shutdown() {
        if (serviceRegistry != null) {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }
    }

    public void close() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
