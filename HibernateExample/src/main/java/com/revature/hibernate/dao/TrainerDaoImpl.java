package com.revature.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;
import com.revature.hibernate.util.HibernateUtil;

public class TrainerDaoImpl implements TrainerDao {
	
	private static TrainerDaoImpl instance;
	private TrainerDaoImpl() {}
	
	public static TrainerDaoImpl getInstance() {
		if (instance == null) {
			instance = new TrainerDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Trainer> getAllTrainers() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Trainer> trainers = session.createQuery("from Trainer", Trainer.class).getResultList();
			return trainers;
		} catch(HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return null;
	}

	@Override
	public Trainer getTrainer(String trainerName) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			// Get an instance of javax.persistence.criteria.CriteriaBuilder
			CriteriaBuilder builder = session.getCriteriaBuilder();
			
			// Create a Query object by creating an instance of CriteriaQuery
			// The generic type is the expected return type from the Criteria
			CriteriaQuery<Trainer> query = builder.createQuery(Trainer.class);
			
			// Set the criteria Root, which defines variables in the FROM clause
			Root<Trainer> root = query.from(Trainer.class);
			
			// Write the query programmatically
			query.select(root).where(builder.equal(root.get("name"), trainerName));
			
			// Get the result 
			Trainer trainer = session.createQuery(query).getSingleResult();
			
			return trainer;
			
			
//			return (Trainer) session.createCriteria(Trainer.class).add(Restrictions.eq("name", name)).list().get(0);
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public boolean insertTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTrainer(Trainer trainer) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Trainer temp = session.createQuery("from Trainer where name like :name", Trainer.class)
								  .setParameter("name", trainer.getName())
								  .getSingleResult();
			session.delete(temp);
			t.commit();
			System.out.println("Trainer successfully deleted");
			return true;
		} catch (HibernateException hbe) {
			HibernateUtil.rollbackTransaction(t);
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return false;
	}

	@Override
	public boolean insertTrainer(Trainer trainer, Address address) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			trainer.setAddress(address);
			address.setTrainer(trainer);
			session.persist(trainer);
			t.commit();
			System.out.println("Trainer and Address successfully inserted");
			return true;
		} catch (HibernateException hbe) {
			if (t != null) {
				t.rollback();
				System.out.println("Transaction has been rolled back");
			}
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return false;
	}

	@Override
	public boolean addPokemon(String trainerName, String pokemonName) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Trainer trainer = session.createQuery("from Trainer where name like :name", Trainer.class)
							   	     .setParameter("name", trainerName)
							   	     .getSingleResult();
			Pokemon pokemon = session.createQuery("from Pokemon where name like :name", Pokemon.class)
									 .setParameter("name", pokemonName)
									 .getSingleResult();
			trainer.getPokemon().add(pokemon);
			pokemon.getTrainers().add(trainer);
			session.persist(trainer);
			t.commit();
			System.out.println(pokemon.getName() + " successfully added to " + trainer.getName());
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












