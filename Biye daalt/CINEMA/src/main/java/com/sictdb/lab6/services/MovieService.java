package com.sictdb.lab6.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sictdb.lab6.model.Movie;
import com.sictdb.lab6.repository.MovieRepository;
@Service
public class MovieService {
	@Autowired
	private MovieRepository repository;
	
	public Movie saveMovie(Movie movie) {
		return repository.save(movie);
	}
	public List<Movie> getAllMovies(){
		return repository.findAll();
	}
	public Movie getMovieById(long id) {
		return repository.findById(id).orElse(null);
	}
	public void deleteMovieById(long id) {
		repository.deleteById(id);
	}
}
