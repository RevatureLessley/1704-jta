package com.revature.Exec;

public class ResultOutOfRangeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8972289910368882797L;

	public ResultOutOfRangeException() {
		super();
	}
	
	public ResultOutOfRangeException(String msg) {
		super(msg);
	}
	
	public ResultOutOfRangeException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
