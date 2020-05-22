package com.assignment.service;

import java.util.List;

import com.assignment.dto.MovieDto;

public interface MovieService {
	
	public List<MovieDto> getAllMovies();
	
	public void addMovie(MovieDto movie);
	
	public MovieDto getMovie(long id);
	
	public void deleteMovie(long id);
	
	public void updateMovie(long id,MovieDto movie);

}
