package com.revature.dao;

import java.util.List;

import com.revature.model.Pokemon;

public interface PokemonDao {
	
	List<Pokemon> getAllPokemon();
	Pokemon getPokemon(String name);
	boolean insertPokemon(Pokemon pokemon);
}
