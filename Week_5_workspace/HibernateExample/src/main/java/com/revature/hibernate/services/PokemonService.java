package com.revature.hibernate.services;

import java.util.List;

import com.revature.hibernate.dao.PokemonDao;
import com.revature.hibernate.dao.PokemonDaoImpl;
import com.revature.hibernate.entity.Pokemon;

public class PokemonService {

	private static PokemonDao dao = PokemonDaoImpl.getInstance();

	private PokemonService() {
	}

	public static List<Pokemon> getAllPokemon() {
		return dao.getAllPokemon();
	}

	public static Pokemon getPokemon(String name) {
		return dao.getPokemon(name);
	}

	public static boolean insertPokemon(Pokemon pokemon) {
		return dao.insertPokemon(pokemon);
	}

	public static boolean updatePokemon(Pokemon pokemon) {
		return dao.updatePokemon(pokemon);
	}

	public static boolean deletePokemon(Pokemon pokemon) {
		return dao.deletePokemon(pokemon);
	}

}
