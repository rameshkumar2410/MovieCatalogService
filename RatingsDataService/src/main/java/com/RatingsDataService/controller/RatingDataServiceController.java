package com.RatingsDataService.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingsDataService.model.Ratings;

@RestController
@RequestMapping("/ratings")
public class RatingDataServiceController {

	@RequestMapping("/{movieId}")
	public Ratings getRatingDetails(@PathVariable("movieId")String movieId) {
		return new Ratings("Terminator",5);
	}
	
	
}
