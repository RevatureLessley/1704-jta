package com.revature.hibernate.dao;

import java.util.List;

import com.revature.hibernate.entity.Pokemon;

public interface PokemonDao {

	List<Pokemon> getAllPokemon();
	List<Pokemon> getAllPokemonByType(String type);
	Pokemon getPokemon(String name);
	boolean insertPokemon(Pokemon pokemon);
	boolean insertPokemon(Pokemon pokemon, String primaryType);
	boolean insertPokemon(Pokemon pokemon, String primaryType, String secondaryType);
	boolean addType(String pokemonName, String primaryType); // Used to add type to an existing Pokemon
	boolean addType(String pokemonName, String primaryType, String secondaryType); // used to add type to an existing Pokemon
	boolean updatePokemon(Pokemon pokemon);
	boolean deletePokemon(Pokemon pokemon);
	
}
