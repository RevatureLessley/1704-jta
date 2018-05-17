package com.reavature.application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.util.HibernateUtil;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
//			Employee employee = new Employee("Dunn", "email@email.com");
//			session.save(employee);
			
			Pokemon pokemon = new Pokemon("Pidgey");
			session.save(pokemon);

			transaction.commit();
			
		} catch (HibernateException he) {
			if (transaction != null) {
				transaction.rollback();
				System.out.println("Transaction successfully rolledback");
			}
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed " + !session.isOpen());
			}
		}
	}
}
