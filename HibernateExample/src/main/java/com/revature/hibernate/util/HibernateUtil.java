package com.revature.hibernate.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private HibernateUtil() {}
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Properties props = new Properties();
		Configuration cfg = new Configuration();
		try {
			// Load our hibernate.properties file
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
			
			// Set the properties to the Configuration
			cfg.setProperties(props);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		// configure() looks in src/main/resources for the hibernate.cfg.xml file by default
		return cfg.configure().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		System.out.println("Shutting down SessionFactory...");
		getSessionFactory().close();
		System.out.println("SessionFactory closed");
	}
	
	public static void shutdownSession(Session session) {
		if (session != null) {
			session.close();
			System.out.println("Session successfully closed: " + !session.isOpen());
		}
	}
	
	public static void rollbackTransaction(Transaction t) {
		if (t != null) {
			t.rollback();
			System.out.println("Transaction has been rolled back");
		}
	}
}







