package com.revature.service;

import java.util.List;

import javax.persistence.NoResultException;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoImpl;
import com.revature.model.Pokemon;
import com.revature.resources.exceptions.PokemonNotFoundException;
import com.revature.resources.exceptions.YouHaveThisPokemonException;

public class PokemonService {

	private static PokemonDao dao = PokemonDaoImpl.getInstance();
	private PokemonService() {}
	
	public static List<Pokemon> getAllPokemon() {
		return dao.getAllPokemon();
	}
	
	public static Pokemon getPokemon(String name) {
		try {
			return dao.getPokemon(name);
		} catch (NoResultException nre) {
			throw new PokemonNotFoundException(404, "You have not caught the pokemon, " + name);
		}
	}
	
	public static boolean insertPokemon(Pokemon pokemon) {
		if (dao.insertPokemon(pokemon))
			return true;
		throw new YouHaveThisPokemonException(400, "You have already caught the pokemon, " + pokemon.getName());
	}

	public static boolean updatePokemon(Pokemon pokemon) {
		if (dao.updatePokemon(pokemon)) {
			return true;
		}
		throw new PokemonNotFoundException(400, "You have not caught the pokemon, " + pokemon.getName() + ", so you cannot update it.");
	}
	
	public static boolean deletePokemon(String name) {
		if (dao.deletePokemon(name)) {
			return true;
		}
		throw new PokemonNotFoundException(400, "You have not caught the pokemon, " + name + ", so you cannot remove it.");
	}
}
