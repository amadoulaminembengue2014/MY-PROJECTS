package com.vlmcode.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlmcode.ENTITY.Movie;
import com.vlmcode.REPOSITORY.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie> allMoies(){
		return movieRepository.findAll();
	}
	
	public Optional<Movie> singleMovie(String imdbId) {
		return movieRepository.findMovieByImdbId(imdbId);
	}

}
