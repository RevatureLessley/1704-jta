package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Type;
import com.revature.hibernate.util.HibernateUtil;

public class TypeDaoImplementation implements TypeDao {
	
	private static TypeDaoImplementation instance;
	private TypeDaoImplementation() {}
	
	public static TypeDaoImplementation getInstance() {
		if (instance == null) {
			instance = new TypeDaoImplementation();
		}
		return instance;
	}

	@Override
	public List<Type> getAllTypes() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Type", Type.class).getResultList();
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public boolean insertType(String type) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(new Type(type));
			t.commit();
			System.out.println(type + " successfully added");
			return true;
		} catch (HibernateException hbe) {
			HibernateUtil.rollbackTransaction(t);
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return false;
	}

}
