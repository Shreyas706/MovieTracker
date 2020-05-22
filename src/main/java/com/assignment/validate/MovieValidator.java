package com.assignment.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.assignment.dto.MovieDto;
import com.assignment.entity.Movie;
import com.assignment.exception.MovieDataValidationException;
import com.assignment.utill.MovieRequest;

@Component
public class MovieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(MovieRequest.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MovieRequest<MovieDto> movie = (MovieRequest<MovieDto>) target;

		if (movie.getRequestBody().getRating() < 0.5f || movie.getRequestBody().getRating() > 5.0f) {
			errors.reject("error.rating", "rating should be between 0.5 to 5");
			throw new MovieDataValidationException("rating should be between 0.5 to 5");
			
		}

	}

}
