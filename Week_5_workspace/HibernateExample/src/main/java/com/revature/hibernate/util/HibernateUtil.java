package com.revature.hibernate.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private HibernateUtil () {}
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		// This is for if all the properties are in the cfg.xml file
//		return new Configuration().configure().buildSessionFactory();
		
		Properties props = new Properties();
		Configuration cfg = new Configuration();
		try {
			// Load our hibernate properties
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
			
			// Set properties to the Configuration
			cfg.setProperties(props);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return cfg.configure().buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		System.out.println("Shutting down the session factory");
		getSessionFactory().close();
		System.out.println("Session Factory closed");
	}
	
	public static void shutdownSession(Session session) {
		if (session != null) {
			session.close();
			System.out.println("session successfully closed: " + !session.isOpen());
		}

	}

	public static void rollbackSession(Transaction trans) {
		if (trans != null) {
			trans.rollback();
			System.out.println("Transaction has been rolledback");
		}

	}

}
