package com.revature.service;

public class PokemonNotFoundException extends Exception {


	private static final long serialVersionUID = 2189499037787494268L;

	public PokemonNotFoundException() {
	}

	public PokemonNotFoundException(String message) {
		super(message);
	}

	public PokemonNotFoundException(Throwable cause) {
		super(cause);
	}

	public PokemonNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PokemonNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
