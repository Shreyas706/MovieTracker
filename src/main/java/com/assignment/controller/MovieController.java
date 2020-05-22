package com.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.MovieDto;
import com.assignment.entity.Movie;
import com.assignment.service.MovieService;
import com.assignment.utill.MovieRequest;
import com.assignment.utill.MovieResponse;
import com.assignment.validate.MovieValidator;

@RestController
public class MovieController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/movie")
	public MovieResponse<List<MovieDto>> getAllMovie() {
		LOGGER.info("method getAllMovie start");
		MovieResponse<List<MovieDto>> movieResponse = new MovieResponse<List<MovieDto>>();
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setResponse(movieService.getAllMovies());
		LOGGER.info("method getAllMovie end");
		return movieResponse;
	}

	@PostMapping("/movie")
	public MovieResponse addMovie(@RequestBody @Valid MovieRequest<MovieDto> movieRequest, BindingResult errors) {
		LOGGER.info("method addMovie start");
		MovieResponse movieResponse = new MovieResponse();
		movieService.addMovie(movieRequest.getRequestBody());
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("Movie inserted successfully");
		LOGGER.info("method addMovie end");
		return movieResponse;
	}

	@GetMapping("/movie/{id}")
	public MovieResponse<MovieDto> getMovieByid(@PathVariable("id") long id) {
		LOGGER.info("method getMovieByid start");
		MovieResponse<MovieDto> movieResponse = new MovieResponse<MovieDto>();
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setResponse(movieService.getMovie(id));
		LOGGER.info("method getMovieByid end");
		return movieResponse;
	}

	@DeleteMapping("/movie/{id}")
	public MovieResponse deleteMovieByid(@PathVariable("id") long id) {
		LOGGER.info("method deleteMovieByid start");
		MovieResponse movieResponse = new MovieResponse();
		movieService.deleteMovie(id);
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("movie deleted successfully");
		LOGGER.info("method deleteMovieByid end");
		return movieResponse;
	}

	@PostMapping("/movie/{id}")
	public MovieResponse updateMovie(@PathVariable("id") long id, @RequestBody @Valid MovieRequest<MovieDto> movieRequest,
			BindingResult errors) {
		LOGGER.info("method updateMovie start");
		MovieResponse movieResponse = new MovieResponse();
		
		movieService.updateMovie(id, movieRequest.getRequestBody());
		movieResponse.setStatus(HttpStatus.OK);
		movieResponse.setMessage("Movie updated successfully");
		LOGGER.info("method updateMovie end");
		return movieResponse;
	}

}
