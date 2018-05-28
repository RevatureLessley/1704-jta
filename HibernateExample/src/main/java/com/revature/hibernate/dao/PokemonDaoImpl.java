package com.revature.hibernate.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.hibernate.entity.Pokemon;
import com.revature.hibernate.entity.Trainer;
import com.revature.hibernate.entity.Type;
import com.revature.hibernate.util.HibernateUtil;

public class PokemonDaoImpl implements PokemonDao {
	
	private static PokemonDaoImpl instance;
	private PokemonDaoImpl() {}
	
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
			List<Pokemon> pokemon = session.createQuery("from com.revature.hibernate.entity.Pokemon", Pokemon.class).getResultList();
			return pokemon;
		} catch (HibernateException hbe) {
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
	public Pokemon getPokemon(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Pokemon pokemon = session.createQuery("from Pokemon p where p.name like :pokemonName", Pokemon.class)
									 .setParameter("pokemonName", name).getSingleResult();
			return pokemon;
		} catch (HibernateException hbe) {
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
	public boolean insertPokemon(Pokemon pokemon) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.save(pokemon);
			t.commit();
			System.out.println(pokemon.getName() + " successfully inserted");
			return true;
		} catch (HibernateException hbe) {
			if (t != null) {
				t.rollback();
				System.out.println("Transaction successfully rolled back");
			}
			hbe.printStackTrace();
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
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Pokemon temp = session.get(Pokemon.class, pokemon.getId());
			temp.setName(pokemon.getName());
			session.update(temp);
			t.commit();
			System.out.println(pokemon.getName() + " successfully updated");
			return true;
		} catch (HibernateException hbe) {
			if (t != null) {
				t.rollback();
				System.out.println("Transaction successfully rolled back");
			}
			hbe.printStackTrace();
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
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			session.delete(pokemon);
			t.commit();
			System.out.println("Pokemon successfully deleted");
			return true;
		} catch (HibernateException hbe) {
			if (t != null) {
				t.rollback();
				System.out.println("Transaction successfully rolled back");
			}
			hbe.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session successfully closed: " + !session.isOpen());
			}
		}
		return false;
	}

	@Override
	public boolean insertPokemon(Pokemon pokemon, String primaryType) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			
			Type primary = session.createQuery("from Type where name like :name", Type.class)
					  .setParameter("name", primaryType)
					  .getSingleResult();
			pokemon.getTypes().add(primary);
			primary.setPokemon(pokemon);
			
			session.persist(pokemon);
			
			t.commit();
			System.out.println(pokemon.getName() + " successfully inserted");
		} catch (HibernateException hbe) {
			HibernateUtil.rollbackTransaction(t);
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return false;
	}

	@Override
	public boolean insertPokemon(Pokemon pokemon, String primaryType, String secondaryType) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			
			Type primary = session.createQuery("from Type where name like :name", Type.class)
								  .setParameter("name", primaryType)
								  .getSingleResult();
			Type secondary = session.createQuery("from Type where name like :secondary", Type.class)
									.setParameter("secondary", secondaryType)
									.getSingleResult();
			pokemon.getTypes().add(primary);
			pokemon.getTypes().add(secondary);
			primary.setPokemon(pokemon);
			secondary.setPokemon(pokemon);
			
			session.persist(pokemon);
			
			t.commit();
			System.out.println(pokemon.getName() + " successfully added");
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
	public List<Pokemon> getAllPokemonByType(String type) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			return session.createQuery("select pokemon from Type t where t.name like :type", Pokemon.class)
						  .setParameter("type", type)
						  .getResultList();
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public boolean addType(String pokemonName, String primaryType) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Pokemon pokemon = session.createQuery("from Pokemon where name like :name", Pokemon.class)
									 .setParameter("name", pokemonName)
									 .getSingleResult();
			Type primary = new Type(primaryType);
			pokemon.getTypes().add(primary);
			primary.setPokemon(pokemon);
			session.persist(pokemon);
			t.commit();
			System.out.println(pokemonName + " is now " + primaryType + " type");
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
	public boolean addType(String pokemonName, String primaryType, String secondaryType) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			t = session.beginTransaction();
			Pokemon pokemon = session.createQuery("from Pokemon where name like :name", Pokemon.class)
									 .setParameter("name", pokemonName)
									 .getSingleResult();
			Type primary = new Type(primaryType);
			Type secondary = new Type(secondaryType);
			
			pokemon.getTypes().add(primary);
			pokemon.getTypes().add(secondary);
			primary.setPokemon(pokemon);
			secondary.setPokemon(pokemon);
			session.persist(pokemon);
			t.commit();
			System.out.println(pokemonName + " is now " + primaryType + "/" + secondaryType + " type");
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







