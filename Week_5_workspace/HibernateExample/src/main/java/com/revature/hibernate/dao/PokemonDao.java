package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.entity.Pokemon;

public interface PokemonDao {

	List<Pokemon> getAllPokemon();
	Pokemon getPokemon(String name);
	
	boolean insertPokemon(Pokemon pokemon);
	boolean updatePokemon(Pokemon pokemon);
	boolean deletePokemon(Pokemon pokemon);
	
}
