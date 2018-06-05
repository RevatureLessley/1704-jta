package com.revature.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private HibernateUtil() {}
	
	private static SessionFactory buildSessionFactory() {
		Configuration cfg = new Configuration();
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		cfg.setProperties(props);
		return cfg.configure().buildSessionFactory();
	}
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static void shutdown() {
		System.out.println("Closing SessionFactory...");
		sessionFactory.close();
		System.out.println("SessionFactory closed");
	}
	
	public static void shutdownSession(Session session) {
		if (session != null) {
			session.close();
			System.out.println("Session close: " + !session.isOpen());
		}
	}
	
	public static void rollbackTransaction(Transaction t) {
		if (t != null) {
			t.rollback();
			System.out.println("Transaction successfully rolled back");
		}
	}
}
