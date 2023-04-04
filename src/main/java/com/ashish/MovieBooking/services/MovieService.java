package com.ashish.MovieBooking.services;

//This interface will define methods defined by MovieService

import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.exceptions.MovieDetailsNotFoundException;

import java.util.List;

public interface MovieService {

    //take a movie request and save it to database
    public MovieDto acceptMovieDetails(MovieDto movie);

    // Get the movie details based on movieId
    public MovieDto getMovieDetails(int id) throws MovieDetailsNotFoundException;

    // Update the Details of the Existing Movie
    public MovieDto updateMovieDetails(int id, MovieDto movie) throws MovieDetailsNotFoundException;

    // Delete a movie
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException;

    // Get the List of all the movies present
    public List<MovieDto> getAllMovieDetails();

    // Deleting a movie from User end but keeping in the DB
    public boolean deleteMovieNot(int id) throws MovieDetailsNotFoundException;


}
