package com.revature.Exec;

public class NonPositiveValueException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8497244615743875109L;

	public NonPositiveValueException() {
		super();
	}
	
	public NonPositiveValueException(String msg) {
		super(msg);
	}
	
	public NonPositiveValueException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
