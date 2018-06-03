package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.model.Pokemon;

// endpointInterface tells Apache CXF that this class' methods will be used for SOAP interactions
@WebService(endpointInterface="com.revature.service.PokemonLibrary")
public class PokemonLibraryImpl implements PokemonLibrary {

	@Override
	public List<Pokemon> getAllPokemon() {
		List<Pokemon> pokemon = new ArrayList<>();
		pokemon.add(new Pokemon(1, "Bulbasaur", "Grass"));
		pokemon.add(new Pokemon(4, "Charmander", "Fire"));
		pokemon.add(new Pokemon(7, "Squirtle", "Water"));
		pokemon.add(new Pokemon(25, "Pikachu", "Electric"));
		return pokemon;
	}

	@Override
	public Pokemon getPokemon(String name) throws PokemonNotFoundException {
		for (Pokemon p : this.getAllPokemon()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		throw new PokemonNotFoundException(name + " could not be found");
	}

}
