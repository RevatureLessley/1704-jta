package com.revature.service;

import java.util.List;

import javax.persistence.NoResultException;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoImpl;
import com.revature.model.Pokemon;
import com.revature.resources.exceptions.PokemonNotFoundException;

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
			throw new PokemonNotFoundException(404, name + " does not exist.");
		}
	}
	
	public static boolean insertPokemon(Pokemon pokemon) {
		return dao.insertPokemon(pokemon);
	}
	
	public static void main(String[] args) {
		for (Pokemon p : getAllPokemon()) {
			System.out.println(p);
		}
	}
}
