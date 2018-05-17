package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.util.HibernateUtil;

public class AddressDaoImpl implements AddressDao{

	private static AddressDaoImpl instance;

	private AddressDaoImpl() {
	}

	public static AddressDaoImpl getInstance() {
		if (instance == null) {
			instance = new AddressDaoImpl();
		}
		return instance;
	}

	
	
	@Override
	public List<Address> getAllAddresses() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("from Address", Address.class).getResultList();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

}
