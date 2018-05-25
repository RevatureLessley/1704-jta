package com.revature.driver;

public class DriverNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8439117197819742246L;
	
	public DriverNotFoundException() {
		super();
	}
	
	public DriverNotFoundException(String msg) {
		super(msg);
	}

	public DriverNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}


}
