package com.revature.resources.exceptions;

public class PokemonNotFoundException extends PokeAPIException{

	public PokemonNotFoundException(int statusCode, String message) {
		super(statusCode, message);
	}
	
	public PokemonNotFoundException() {
		super();
	}

	private static final long serialVersionUID = 4865948769847751340L;

}
