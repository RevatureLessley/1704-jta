package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.BoringPokemon;

public class BoringPokemonDaoImpl implements BoringPokemonDao {

	@Override
	public List<BoringPokemon> getAllPokemon() {
		List<BoringPokemon> myBoringPokemon = new ArrayList<>();
		myBoringPokemon.add(new BoringPokemon(1, "Bulbasaur", "Grass", "Poison"));
		myBoringPokemon.add(new BoringPokemon(4, "Charmander", "Fire", null));
		myBoringPokemon.add(new BoringPokemon(7, "Squirtle", "Water", null));
		return myBoringPokemon;
	}

	@Override
	public BoringPokemon getBoringPokemon(String name) {
		for (BoringPokemon p : this.getAllPokemon()) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

}
