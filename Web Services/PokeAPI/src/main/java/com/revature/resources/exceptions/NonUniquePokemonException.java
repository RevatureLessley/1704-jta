package com.revature.resources.exceptions;

public class NonUniquePokemonException extends PokeAPIException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NonUniquePokemonException() {
		super();
	}
	
	public NonUniquePokemonException(int code, String message) {
		super(code, message);
	}
	
	
}
