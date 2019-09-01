package com.movie.controller;

import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/home", produces="application/json")
public class MovieCatalogController {
	
	
	@GetMapping(value="/getMovieCatalog")
	@ResponseBody
	public Stream<String> getMovieCatalog(){
		Stream<String> movie=Stream.of("MI2","Terminator","Road Trip");
		return movie;
	}

}
