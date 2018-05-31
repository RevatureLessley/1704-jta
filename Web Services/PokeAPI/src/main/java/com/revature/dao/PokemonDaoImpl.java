package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Pokemon;
import com.revature.util.HibernateUtil;

public class PokemonDaoImpl implements PokemonDao {

	private static PokemonDaoImpl instance;
	private PokemonDaoImpl() {}
	
	public static PokemonDaoImpl getInstance() {
		if (instance == null) 
			instance = new PokemonDaoImpl();
		return instance;
	}
	
	@Override
	public List<Pokemon> getAllPokemon() {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			return session.createQuery("from Pokemon order by pokedexId", Pokemon.class).getResultList();
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public Pokemon getPokemon(String name) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			return session.createQuery("from Pokemon where name like :pokemonName", Pokemon.class)
						  .setParameter("pokemonName", name).getSingleResult();
		} catch (HibernateException hbe) {
			hbe.printStackTrace();
		} finally {
			HibernateUtil.shutdownSession(session);
		}
		return null;
	}

	@Override
	public boolean insertPokemon(Pokemon pokemon) {
		Session session = null;
		Transaction t = null;
		try {
			session = HibernateUtil.getSession();
			t = session.beginTransaction();
			session.save(pokemon);
			t.commit();
			System.out.println(pokemon.getName() + " successfully inserted");
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





