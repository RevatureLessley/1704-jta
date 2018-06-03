package com.revature.resources.exceptions;

public class NonUniquePokemonException extends PokeAPIException {

	private static final long serialVersionUID = -6048301789814173977L;

	public NonUniquePokemonException() {
		super();
	}

	public NonUniquePokemonException(int statusCode, String message) {
		super(statusCode, message);
	}

}
