package com.teamsea.api.exception;

/**
 * 这个异常是针对一些方法使用的
 * 
 * 
 * */
public class ValueAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValueAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValueAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ValueAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValueAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValueAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
