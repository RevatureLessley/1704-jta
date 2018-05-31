package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Pokemon;

// @WebService denotes a SOAP web service
@WebService 
public interface PokemonLibrary {

	List<Pokemon> getAllPokemon();
	Pokemon getPokemon(String name) throws PokemonNotFoundException;
}
