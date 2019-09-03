package com.movie.models;

public class Ratings {

	private String movieId;
	private int ratings;

	public Ratings() {
		super();
	}

	public Ratings(String movieId, int ratings) {
		super();
		this.movieId = movieId;
		this.ratings = ratings;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

}
