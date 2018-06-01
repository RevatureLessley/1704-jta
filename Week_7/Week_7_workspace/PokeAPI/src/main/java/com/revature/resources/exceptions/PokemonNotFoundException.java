package com.revature.resources.exceptions;

public class PokemonNotFoundException extends PokeAPIException {

	private static final long serialVersionUID = 3910925996196098612L;

	public PokemonNotFoundException() {
	}

	public PokemonNotFoundException(int statusCode, String message) {
		super(statusCode, message);
	}

}
