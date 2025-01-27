/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.tutorial.annotations;

import static java.lang.System.out;
import static java.time.LocalDateTime.now;

import java.sql.SQLException;


import org.hibernate.SessionFactory;

import org.hibernate.tutorial.SessionFactoryUtil;
import org.hibernate.tutorial.model.Event;

import junit.framework.TestCase;

/**
 * Illustrates the use of Hibernate native APIs, including the use
 * of org.hibernate.boot for configuration and bootstrap.
 * Configuration properties are sourced from hibernate.properties.
 *
 * @author Steve Ebersole
 */
public class HibernateIllustrationTest extends TestCase {
	private SessionFactory sessionFactory;

	@Override
	protected void setUp() {
		// A SessionFactory is set up once for an application!
		
		try {
			sessionFactory =
					SessionFactoryUtil.getSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we
			// had trouble building the SessionFactory so destroy it manually.
			e.printStackTrace();
		}
	}

	@Override
	protected void tearDown() {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}
	}

	public void testBasicUsage() throws SQLException {
		// create a couple of events...
		sessionFactory.inTransaction(session -> {
			session.persist(new Event("Our very first event 2025!", now()));
			session.persist(new Event("A follow up event 2025", now()));
		});

		// now lets pull events from the database and list them
		sessionFactory.inTransaction(session -> {
			session.createSelectionQuery("from Event", Event.class).getResultList()
					.forEach(event -> out.println("Event (" + event.getDate() + ") : " + event.getTitle()));
		});
		

	}
	
	
}
