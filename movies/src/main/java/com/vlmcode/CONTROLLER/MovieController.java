package com.vlmcode.CONTROLLER;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vlmcode.ENTITY.Movie;
import com.vlmcode.SERVICE.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	/*
	 * @GetMapping 
	 * public ResponseEntity<String> allMovies(){ 
	 * return new ResponseEntity<String>("All Movies!", HttpStatus.OK); }
	 */
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		return new ResponseEntity<List<Movie>>(movieService.allMoies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
		return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
	}

}
