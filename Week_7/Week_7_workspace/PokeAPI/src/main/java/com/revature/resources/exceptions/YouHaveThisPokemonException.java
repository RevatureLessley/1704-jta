package com.revature.resources.exceptions;

public class YouHaveThisPokemonException extends PokeAPIException {

	private static final long serialVersionUID = -9180809344460156897L;

	public YouHaveThisPokemonException() {
	}

	public YouHaveThisPokemonException(int statusCode, String message) {
		super(statusCode, message);
	}

}
