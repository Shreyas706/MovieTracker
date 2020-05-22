package com.assignment.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.MovieDto;
import com.assignment.entity.Movie;
import com.assignment.exception.MovieNotFoundException;
import com.assignment.repository.MovieRepository;
import com.assignment.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieDto> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
		List<MovieDto> movieDtos = new ArrayList<MovieDto>();
		for (Movie movie : movies) {
			MovieDto dto = new MovieDto(movie.getId(), movie.getTitle(), movie.getCategory(), movie.getRating());
			movieDtos.add(dto);
		}
		return movieDtos;
	}

	@Override
	public void addMovie(MovieDto movie) {
		Movie movie2=new Movie(movie.getTitle(), movie.getCategory(), movie.getRating());
		movieRepository.save(movie2);
	}

	@Override
	public MovieDto getMovie(long id) {
		Movie movie=movieRepository.findById(id).get();
		if(movie==null)
			throw new MovieNotFoundException("Movie not exit with id "+id);
		return new MovieDto(movie.getId(),movie.getTitle(),movie.getCategory(),movie.getRating());
	}

	@Override
	public void deleteMovie(long id) {
		Movie movie=movieRepository.findById(id).get();
		if(movie==null)
			throw new MovieNotFoundException("Movie not exit with id "+id);
		movieRepository.deleteByMovieId(id);

	}

	@Transactional
	@Override
	public void updateMovie(long id, MovieDto dto) {
		Movie movie=movieRepository.findById(id).get();
		if(movie==null)
			throw new MovieNotFoundException("Movie not exit with id "+id);
		movie.setTitle(dto.getTitle());
		movie.setCategory(dto.getCategory());
		movie.setRating(dto.getRating());
		
	}

}
