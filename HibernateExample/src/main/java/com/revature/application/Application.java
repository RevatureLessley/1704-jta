package com.revature.application;

import java.util.List;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Trainer;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Type;
import com.revature.hibernate.services.PokemonService;
import com.revature.hibernate.util.HibernateUtil;
import org.hibernate.Transaction;

public class Application {

	public static void main(String[] args) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Trainer brock = new Trainer(29, "Brock");
			Address brockAddress = new Address("rocke road", "Pew City");
			brock.setAddress(brockAddress);
			brockAddress.setTrainer(brock);

			session.persist(brock);
			t.commit();
		} catch (HibernateException hbe) {
			if (t != null) {
				t.rollback();
				System.out.println("Transaction successfully rolled back!");
			}
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session sucessfully closed!" + !session.isOpen());
			}
		}
		HibernateUtil.shutdown();
	}
}















