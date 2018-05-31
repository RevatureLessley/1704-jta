package com.revature.service;

import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoImpl;
import com.revature.model.Pokemon;

public class PokemonService {

	private static PokemonDao dao = PokemonDaoImpl.getInstance();
	private PokemonService() {}
	
	public static List<Pokemon> getAllPokemon() {
		return dao.getAllPokemon();
	}
	
	public static Pokemon getPokemon(String name) {
		return dao.getPokemon(name);
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
