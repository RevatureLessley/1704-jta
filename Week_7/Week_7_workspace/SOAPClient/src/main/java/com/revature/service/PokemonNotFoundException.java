package com.revature.service;

public class PokemonNotFoundException extends Exception {

	private static final long serialVersionUID = 6091500291685483290L;

	public PokemonNotFoundException() {
		super();
	}

	public PokemonNotFoundException(Throwable cause) {
		super(cause);
	}

	public PokemonNotFoundException(String message) {
		super(message);
	}

	public PokemonNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PokemonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
