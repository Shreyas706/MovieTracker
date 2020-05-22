package com.assignment.exception;

public class MovieNotFoundException extends RuntimeException {

	public MovieNotFoundException() {
		super();
		 
	}

	public MovieNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		 
	}

	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
		 
	}

	public MovieNotFoundException(String message) {
		super(message);
		 
	}

	public MovieNotFoundException(Throwable cause) {
		super(cause);
		 
	}
	
	

}
