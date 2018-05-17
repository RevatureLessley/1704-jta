package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.revature.hibernate.entity.Address;
import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;
import com.revature.hibernate.util.HibernateUtil;

public class TrainerDaoImpl implements TrainerDao {

	private static TrainerDaoImpl instance;

	private TrainerDaoImpl() {
	}

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
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public Trainer getTrainer(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Trainer> query = builder.createQuery(Trainer.class);
//			Root<Trainer> root = query.from(Trainer.class);
//			query.select(root);
//			query.where(builder.equal(root.get(Trainer.class.getName()), name));
//			Trainer t = session.createQuery(query).getSingleResult();
//			return t;
			
			return (Trainer) session.createCriteria(Trainer.class).add(Restrictions.eq("name", name)).list().get(0);
		} catch (HibernateException he) {
			he.printStackTrace();
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
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(trainer);
			trans.commit();
			System.out.println("Trainer successfully deleted");
			return true;
		} catch (HibernateException he) {
			HibernateUtil.rollbackSession(trans);
			he.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		
		return false;
	}

	@Override
	public boolean insertTrainer(Trainer trainer, Address address) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			
			trainer.setAddress(address);
			address.setTrainer(trainer);
			
			session.persist(trainer);
			trans.commit();
			System.out.println("Trainer and Address successfully inserted");
			
			return true;
		} catch (HibernateException he) {
			HibernateUtil.rollbackSession(trans);
			he.printStackTrace();
			
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return false;
	}

	@Override
	public boolean addPokemon(String trainerName, Pokemon pokemon) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Trainer trainer = session.createQuery("from Trainer where name like :name", Trainer.class)
										.setParameter("name", trainerName)
										.getSingleResult();
			trainer.getPokemon().add(pokemon);
			pokemon.getTrainers().add(trainer);
			session.update(trainer);
			trans.commit();
			System.out.println(pokemon.getName() + " successfully caught by " + trainer.getName());
			return true;
		} catch (HibernateException he) {
			HibernateUtil.rollbackSession(trans);
			he.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		
		return false;
	}

}




























