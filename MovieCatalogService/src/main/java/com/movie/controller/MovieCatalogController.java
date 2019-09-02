package com.movie.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.movie.models.CatalogItem;
import com.movie.models.Movie;
import com.movie.models.Ratings;

/**
 * Microservice for Movie catalog
 * 
 * @author Ramesh
 *
 */

@RestController
@RequestMapping(value = "/movie", produces = "application/json")
public class MovieCatalogController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder builder;

	@RequestMapping(value = "/{userID}")
	public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {

		List<Ratings> ratingList = Arrays.asList(new Ratings("1234", 4), new Ratings("2345", 5));

		return ratingList.stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:8762/infoService/" + rating.getMovieId(),
					Movie.class);

			/*Movie movie=builder.build()
			.get()
			.uri("http://localhost:8762/infoService/\" + rating.getMovieId()")
			.retrieve()
			.bodyToMono(Movie.class)
			.block();*/
			
			return new CatalogItem(movie.getName(), "Robot", rating.getRatings());
		}).collect(Collectors.toList());
		// return (List<CatalogItem>) Collections.singletonList(new
		// CatalogItem("Transformer", "Robot", 8));

	}

	@GetMapping(value = "/getMovieCatalog")
	@ResponseBody
	public Stream<String> getMovieCatalog() {
		Stream<String> movie = Stream.of("MI2", "Terminator", "Road Trip");
		return movie;
	}

}
