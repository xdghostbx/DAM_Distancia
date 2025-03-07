package com.example.hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.hibernate.model.Profesor;
import com.example.hibernate.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
      // Get the singleton instance of HibernateUtil
      HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        
      // Retrieve the SessionFactory
      SessionFactory sessionFactory = hibernateUtil.getSessionFactory();

      // Open a session
      Session session = sessionFactory.openSession();

	

		{
			System.out.println("-----------Q1: Uso de list() -----------");

			List<Profesor> profesores = (List<Profesor> )session.createSelectionQuery(" select p FROM Profesor p ", Profesor.class)
                    .getResultList();

			for (Profesor profesor : profesores) {
				System.out.println(profesor);
			}
		}

		
    }
}