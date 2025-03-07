import java.lang.annotation.Inherited;

import javax.security.auth.login.Configuration;

public class Apuntes {
    /*
     * Clases y conceptos clave en Hibernate:
     * 1. SessionFactory y Session: Clases que permiten la conexión a la base de datos y la realización de operaciones.
     * 2. Entity y Table: mapeo de clases a tablas.
     * 3. Operaciones CRUD en Hibernate.
     * 4. HQL: Hibernate Query Language.
     */

     public void Punto1() {
        SessionFactory factory = new Configuration().configure("archivo de configuracion").buildSessionFactory();
        Session session = factory.openSession();
     }

     public void Punto2() {
        /*
         * para que hibernate reconozca una clase como entidad que debe almacenarse usamos las anotaciones
         */
        @Entity
        @Table(name = "personas")
        public class Persona {
            @Id 
            @GeneratedValue(strategy = GenerationType.IDENTITY) // permite que el id sea autoincremental
            private int id;

            @Column(name = "nombre")
            private String nombre;

            @Column(name = "edad")
            private int edad;

            //getters y setters
        }
     }

     public void Punto3() {
        
     }
}
