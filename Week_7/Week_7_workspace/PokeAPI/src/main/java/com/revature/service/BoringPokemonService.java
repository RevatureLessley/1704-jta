package com.revature.service;

import java.util.List;

import com.revature.dao.BoringPokemonDao;
import com.revature.dao.BoringPokemonDaoImpl;
import com.revature.model.BoringPokemon;

public class BoringPokemonService {

	private static BoringPokemonDao dao = new BoringPokemonDaoImpl();
	private BoringPokemonService() {}
	
	public static List<BoringPokemon> getAllBoringPokemon(){
		return dao.getAllBoringPokemon();
	}
	
	public static BoringPokemon getBoringPokemon(String name) {
		return dao.getBoringPokemon(name);
	}
}
