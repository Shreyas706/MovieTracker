package com.assignment.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.assignment.exception.MovieNotFoundException;
import com.assignment.utill.MovieResponse;

@ControllerAdvice
public class RestErrorHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(RestErrorHandler.class);
	 

	@ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MovieResponse handleTodoNotFoundException(MovieNotFoundException ex) {
        LOGGER.error("handling 404 error on a movie entry");
        MovieResponse movieResponse=new MovieResponse();
        movieResponse.setStatus(HttpStatus.NOT_FOUND);
        movieResponse.setMessage(ex.getMessage());
        return movieResponse;
    }
	
	@ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.METHOD_FAILURE)
    public MovieResponse handleTodoNotFoundException(RuntimeException ex) {
        LOGGER.error("handling 402 error on a movie entry");
        MovieResponse movieResponse=new MovieResponse();
        movieResponse.setStatus(HttpStatus.METHOD_FAILURE);
        movieResponse.setMessage(ex.getMessage());
        return movieResponse;
    }
	
	
}
