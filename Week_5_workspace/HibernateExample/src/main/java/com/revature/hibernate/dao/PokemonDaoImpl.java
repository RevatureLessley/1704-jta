package com.revature.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.util.HibernateUtil;

public class PokemonDaoImpl implements PokemonDao {

	private static PokemonDaoImpl instance;

	private PokemonDaoImpl() {
	}

	public static PokemonDaoImpl getInstance() {
		if (instance == null) {
			instance = new PokemonDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Pokemon> getAllPokemon() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			List<Pokemon> pokemon = session.createQuery("from com.revature.hibernate.entity.Pokemon", Pokemon.class)
					.getResultList();
			return pokemon;
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}

		}
		return null;
	}

	@Override
	public Pokemon getPokemon(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Pokemon pokemon = session.createQuery("from Pokemon p where p.name like :pokemonName", Pokemon.class)
					.setParameter("pokemonName", name).getSingleResult();
			return pokemon;
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}

		}
		return null;
	}

	@Override
	public boolean insertPokemon(Pokemon pokemon) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.save(pokemon);
			trans.commit();
			System.out.println(pokemon.getName() + " successfully inserted");
		} catch (HibernateException he) {
			if (trans != null) {
				trans.rollback();
				System.out.println("Transaction successfully rolledback, pokemon not inserted");
			}
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return false;
	}

	@Override
	public boolean updatePokemon(Pokemon pokemon) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			Pokemon temp = session.get(Pokemon.class, pokemon.getId());
			temp.setName(pokemon.getName());
			session.update(temp);
			trans.commit();
			System.out.println("Pokemon successfully updated");
			return true;
		} catch (HibernateException he) {
			if (trans != null) {
				trans.rollback();
				System.out.println("Transaction successfully rolledback, pokemon not inserted");
			}
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return false;
	}

	@Override
	public boolean deletePokemon(Pokemon pokemon) {
		Session session = null;
		Transaction trans = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			trans = session.beginTransaction();
			session.delete(pokemon);
			trans.commit();
			System.out.println(pokemon.getName() + " successfully deleted");
			return true;
		} catch (HibernateException he) {
			if (trans != null) {
				trans.rollback();
				System.out.println("Transaction successfully rolledback, pokemon not inserted");
			}
			he.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}

		return false;
	}

}
