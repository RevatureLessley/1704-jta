package com.revature.resources.exceptions;

public class PokeAPIException extends RuntimeException{
	
	private static final long serialVersionUID = 276282185769724448L;
	private int statusCode;
	private String message;
	
	public PokeAPIException() {
		
	}
	
	public PokeAPIException(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public String getMessage() {
		return this.message;
	}
	
}
