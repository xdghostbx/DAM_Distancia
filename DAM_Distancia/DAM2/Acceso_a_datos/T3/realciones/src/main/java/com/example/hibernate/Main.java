package com.example.hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.hibernate.model.Ciclo;
import com.example.hibernate.model.Profesor;
import com.example.hibernate.util.HibernateUtil;
import com.example.hibernate.util.ProfesorInfo;

public class Main {
        public static void main(String[] args) {
                // Get the singleton instance of HibernateUtil
                HibernateUtil hibernateUtil = HibernateUtil.getInstance();

                // Retrieve the SessionFactory
                SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

                // Open a session
                Session session = sessionFactory.openSession();

                {
                        System.out.println(
                                        "-----------Q1: Selección de objetos de tipo Profesor como listado -----------");

                        List<Profesor> profesores = (List<Profesor>) session
                                        .createSelectionQuery(" select p FROM Profesor p ", Profesor.class)
                                        .getResultList();

                        for (Profesor profesor : profesores) {
                                System.out.println(profesor);
                        }
                }

                {
                        System.out
                                        .println("-----------Q1: Selección de propiedades de la clase  Profesor como listado -----------");

                        List<Object[]> datos = (List<Object[]>) session
                                        .createSelectionQuery("select  p.id, p.nombre  FROM Profesor p ",
                                                        Object[].class)
                                        .getResultList();

                        for (Object[] dato : datos) {
                                System.out.println(dato[0] + "--" + dato[1]);
                        }
                }

                {
                        System.out.println("----------- Q3: Obtención de un único dato escalar -----------");
                        List<Object[]> listDatos = session
                                        .createSelectionQuery("SELECT p.nombre FROM Profesor p", Object[].class)
                                        .getResultList();

                        for (Object[] datos : listDatos) {
                                System.out.println(datos[0]);
                        }
                }

                {
                        System.out.println(
                                        "----------- Q4: Uso de clase com.example.hibernate.util.ProfesorInfo con concatenación de cadenas -----------");
                        List<ProfesorInfo> profInfoList = session.createSelectionQuery(
                                        "SELECT new com.example.hibernate.util.ProfesorInfo(p.nombre || ' ' || p.ape1 || ' ' || p.ape2) FROM Profesor p",
                                        ProfesorInfo.class)
                                        .getResultList();

                        for (ProfesorInfo profeInfo : profInfoList) {
                                System.out.println(profeInfo.getNombreCompleto());
                        }
                }

                {
                        int profeId = 10;
                        System.out.println(
                                        "----------- Q5: Uso de uniqueResult y sustitución de parámetros posicionales -----------");
                        Profesor profesor = session
                                        .createSelectionQuery("SELECT p FROM Profesor p WHERE id=?1", Profesor.class)
                                        .setParameter(1, profeId)
                                        .uniqueResult();
                        System.out.println("Profesor con Id=" + profeId + " " + profesor);
                }

                {
                        int profeId = 10;
                        System.out
                                        .println("----------- Q6: Uso de uniqueResult y sustitución de parámetros nominales  -----------");
                        Profesor profesor = session
                                        .createSelectionQuery("SELECT p FROM Profesor p WHERE id= :profeId",
                                                        Profesor.class)
                                        .setParameter("profeId", profeId)
                                        .uniqueResult();
                        System.out.println("Profesor con Id=" + profeId + " " + profesor);
                }

                {
                        System.out.println("----------- Q8: Uso where + in + parameter list-----------");
                        List<Integer> idList = new ArrayList<Integer>();
                        idList.add(3);
                        idList.add(6);
                        idList.add(9);
                        List<String> names = (List<String>) session
                                        .createSelectionQuery(" SELECT p.nombre FROM Profesor p WHERE id in :listaIds",
                                                        String.class)
                                        .setParameterList("listaIds", idList)
                                        .getResultList();

                        for (String name : names) {
                                System.out.println("Nombre profe en lista: " + name);
                        }
                }

                {
                        System.out.println("----------- Q9: Mostrar una página de resultados  -----------");
                        int tamanyoPagina = 5;
                        int paginaAMostrar = 2; // la primera página sería el 0, la segunda el 1, la 3ª el 2

                        List<Profesor> profesores = session.createSelectionQuery(
                                        "SELECT p FROM Profesor p ORDER BY p.id",
                                        Profesor.class)
                                        .setMaxResults(tamanyoPagina)
                                        .setFirstResult(paginaAMostrar * tamanyoPagina)
                                        .getResultList();

                        for (Profesor profesor : profesores) {
                                System.out.println(profesor);
                        }
                }

                {
                        System.out.println("-----------Q10:  Calcular el nº de páginas -----------");
                        int tamanyoPagina = 10;
                        Long numTotalObjetos = session.createSelectionQuery(
                                        "SELECT COUNT(p) FROM Profesor p",
                                        Long.class).getSingleResult();
                        int numPaginas = (int) Math.ceil((double) numTotalObjetos / (double) tamanyoPagina);

                        System.out.println("Nº total de objetos=" + numTotalObjetos);
                        System.out.println("Nº total de objetos por página =" + tamanyoPagina);
                        System.out.println("Nº de páginas=" + numPaginas);

                }

                {
                        System.out.println("----------- Q11: Simple consulta con HQL -----------");
                        System.out.println(
                                        "----------- Q11:  He renombrado a mano Ciclo que era originalmente cicloformativo y el atributo nombreCiclo a nombre-----------");
                        System.out.println(
                                        "----------- Q11:  También hubo que añadir un toString a CicloFormativo -----------");

                        // He renombrado a mano CicloFormativo que estaba originalmente cicloformativo
                        // También hubo que añadir un toString a CicloFormativo
                        List<Ciclo> ciclos = session
                                        .createSelectionQuery("SELECT c FROM Ciclo c ORDER BY c.nombre", Ciclo.class)
                                        .getResultList();

                        for (Ciclo ciclo : ciclos) {
                                System.out.println(ciclo.toString());
                        }

                }

                {
                        System.out.println("----------- Q12: Uso de AND y OR -----------");
                        List<Profesor> profesores = session
                                        .createSelectionQuery(
                                                        "SELECT p FROM Profesor p WHERE nombre='Juan' AND (ape1='PEREZ' OR ape2='GARCÍA')",
                                                        Profesor.class)
                                        .getResultList();

                        for (Profesor profesor : profesores) {
                                System.out.println(profesor.toString());
                        }
                }

                {
                        System.out.println("----------- Q13: Funciones de agregación -----------");
                        Object[] datos = (Object[]) session
                                        .createSelectionQuery(
                                                        "SELECT AVG(c.horas),SUM(c.horas),MIN(c.horas),MAX(c.horas),COUNT(*) FROM Ciclo c",
                                                        Object[].class)
                                        .uniqueResult();

                        System.out.println("AVG(c.horas)=" + datos[0]);
                        System.out.println("SUM(c.horas)=" + datos[1]);
                        System.out.println("MIN(c.horas)=" + datos[2]);
                        System.out.println("MAX(c.horas)=" + datos[3]);

                }

                {
                        System.out.println("----------- Q14: GROUP BY y HAVING -----------");
                        List<Object[]> listDatos = session
                                        .createSelectionQuery(
                                                        "SELECT nombre,count(nombre) FROM Profesor p GROUP BY p.nombre "
                                                                        + "HAVING count(nombre)>1 ORDER BY count(nombre)",
                                                        Object[].class)
                                        .getResultList();

                        for (Object[] datos : listDatos) {
                                System.out.println("El nombre \"" + datos[0] + "\" se repite  " + datos[1] + " veces");
                        }
                }

                {
                        System.out.println(
                                        "-----------Q15: Subconsultas: Los ciclos con más horas que la media, mostrando también la media -----------");
                        List<Object[]> listDatos = session.createSelectionQuery(
                                        "SELECT c.nombre, c.horas, (select AVG(c3.horas) from Ciclo c3)  " +
                                                        "FROM Ciclo c WHERE c.horas >  (SELECT  AVG(c2.horas) FROM Ciclo c2)",
                                        Object[].class)
                                        .getResultList();

                        for (Object[] datos : listDatos) {
                                System.out.println("El ciclo \"" + datos[0] + "\" es de " + datos[1]
                                                + " horas, siendo mayor que la media de horas de todos los ciclos: "
                                                + datos[2]);
                        }
                }

                {
                        System.out.println("----------- Q16: Boolean -----------");
                        List<Boolean> listDatos = session
                                        .createSelectionQuery("SELECT t.bit1 FROM Tiposbasicos t where t.bit1=false ",
                                                        Boolean.class)
                                        .getResultList();

                        for (Boolean dato : listDatos) {
                                System.out.println("Dato booleano: " + dato);
                        }
                }

                {

                        System.out.println("----------- Q17: LocalDates -----------");
                        System.out.println(
                                        "----------- Q17: Cambiei manualmente os tipos de datos xerados por Hibernate Tools java.sql.{Date, Time, DateTime} por java.time{LocalDate, LocalTime, LocalDateTime} -----------");
                        System.out.println(
                                        "----------- Q17: Hibernate recomenda utilizar java.time.* -> https://docs.jboss.org/hibernate/orm/6.6/introduction/html_single/Hibernate_Introduction.html#miscellaneous-mappings -----------");

                        System.out.println(
                                        "Ver documentación sobre parsing java.time.*: https://docs.oracle.com/javase/tutorial/datetime/iso/format.html");
                        System.out.println(
                                        "Ver documentación sobre crear obxectos java.time.*: https://docs.oracle.com/javase/tutorial/datetime/iso/datetime.html");
                        LocalDate dateFrom = LocalDate.of(1985, Month.OCTOBER, 26);

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                        try {

                                LocalDate dateTo = LocalDate.parse("2023-12-31", formatter);

                                List<LocalDate> dateList = session
                                                .createSelectionQuery(
                                                                "SELECT t.dateDate FROM Tiposbasicos t where t.dateDate between :from and :to",
                                                                LocalDate.class)
                                                .setParameter("from", dateFrom)
                                                .setParameter("to", dateTo)
                                                .getResultList();

                                for (LocalDate date : dateList) {
                                        System.out.println(date);
                                }
                        } catch (DateTimeParseException e) {
                                System.err.println("Ha ocurrido una exception: " + e.getMessage());
                                e.printStackTrace();
                        }

                }
                System.out.println("----------- Q18: NamedQueries -----------");
                System.out.println("----------- Q18: Hay que añadir la query en la clase Profesor -----------");
                {
                        Query<Profesor> query = session.createNamedQuery("Profesor_findByNombreApe1Ap2",
                                        Profesor.class);
                        query.setParameter("nombre", "Laura")
                                        .setParameter("apellido1", "Vivó")
                                        .setParameter("apellido2", "López");
                        List<Profesor> result = query.getResultList();

                        for (Profesor profesor : result) {
                                System.out.println("Se ha encontrado:  " + profesor);
                        }

                }

                {
                        System.out.println("----------- Q19: Funciones de agregación -----------");
                        Object[] datos = session
                                        .createSelectionQuery(
                                                        "SELECT AVG(c.horas),SUM(c.horas),MIN(c.horas),MAX(c.horas),COUNT(*) FROM Ciclo c",
                                                        Object[].class)
                                        .uniqueResult();

                        String[] cabeceras = { "Media", "Suma", "Min.", "Max.", "Total" };
                        for (int i = 0; i < cabeceras.length; i++) {
                                System.out.println(cabeceras[i] + " " + datos[i]);
                        }
                }

                {
                        System.out.println("----------- Q20: OneToOne con PK Iguales -----------");

                        List<Profesor> profesores = session.createSelectionQuery(
                                        "SELECT p FROM Profesor p", Profesor.class)
                                        .getResultList();
                        
                        for (Profesor profesor : profesores) {
                                System.out.println("Datos profe: "+profesor+" ContactInfo: "+profesor.getContactInfo().getTlfMovil());
                        }
                }

        }
}