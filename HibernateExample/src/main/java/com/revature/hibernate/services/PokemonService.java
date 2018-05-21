package com.revature.hibernate.services;

import java.util.List;

import com.revature.hibernate.dao.PokemonDao;
import com.revature.hibernate.dao.PokemonDaoImpl;
import com.revature.hibernate.entity.Pokemon;

public class PokemonService {

	private static PokemonDao dao = PokemonDaoImpl.getInstance();
	private PokemonService() {}
	
	public static List<Pokemon> getAllPokemon() {
		return dao.getAllPokemon();
	}
	
	public static List<Pokemon> getAllPokemonByType(String type) {
		return dao.getAllPokemonByType(type);
	}
	
	public static Pokemon getPokemon(String name) {
		return dao.getPokemon(name);
	}
	
	public static boolean insertPokemon(Pokemon pokemon) {
		return dao.insertPokemon(pokemon);
	}
	
	public static boolean insertPokemon(Pokemon pokemon, String primaryType) {
		return dao.insertPokemon(pokemon, primaryType);
	}
	
	public static boolean insertPokemon(Pokemon pokemon, String primaryType, String secondaryType) {
		return dao.insertPokemon(pokemon, primaryType, secondaryType);
	}
	
	public static boolean addType(String pokemonName, String primaryType) {
		return dao.addType(pokemonName, primaryType);
	}
	
	public static boolean addType(String pokemonName, String primaryType, String secondaryType) {
		return dao.addType(pokemonName, primaryType, secondaryType);
	}
	
	public static boolean updatePokemon(Pokemon pokemon) {
		return dao.updatePokemon(pokemon);
	}
	
	public static boolean deletePokemon(Pokemon pokemon) {
		return dao.deletePokemon(pokemon);
	}
	
}














