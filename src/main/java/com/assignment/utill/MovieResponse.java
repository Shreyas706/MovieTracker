package com.assignment.utill;

import org.springframework.http.HttpStatus;

public class MovieResponse<T> {

	private HttpStatus status;
	private String message;
	private T response;
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	
	
}
