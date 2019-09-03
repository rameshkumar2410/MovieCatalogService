package com.RatingsDataService.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RatingsDataService.model.Ratings;
import com.RatingsDataService.model.UserRatings;

@RestController
@RequestMapping("/ratings")
public class RatingDataServiceController {

	@RequestMapping("/{movieId}")
	public UserRatings getRatingDetails(@PathVariable("movieId")String movieId) {
		
		List<Ratings> ratingList = Arrays.asList(new Ratings("1234", 4), new Ratings("2345", 5));	
		return new UserRatings(ratingList);
	}
	
	
}
