package com.revature.resources.exceptions;

public class PokeAPIException extends RuntimeException {

	private static final long serialVersionUID = -4559111765232983095L;
	private int statusCode;
	private String message;
	
	public PokeAPIException() {}

	public PokeAPIException(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}
}
