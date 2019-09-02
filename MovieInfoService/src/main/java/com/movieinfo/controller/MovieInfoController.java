package com.movieinfo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieinfo.Model.Movie;

@RestController
@RequestMapping("/infoService")
public class MovieInfoController {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		return new Movie("1234", "Transformer Part3");

	}

}
