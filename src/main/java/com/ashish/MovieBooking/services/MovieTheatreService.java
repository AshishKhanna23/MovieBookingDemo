package com.ashish.MovieBooking.services;

import com.ashish.MovieBooking.entities.MovieTheatre;
import com.ashish.MovieBooking.exceptions.MovieDetailsNotFoundException;
import com.ashish.MovieBooking.exceptions.MovieTheatreDetailsNotFoundException;
import com.ashish.MovieBooking.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface MovieTheatreService {

    public MovieTheatre acceptMovieTheatreDetails(MovieTheatre movieTheatre) throws MovieDetailsNotFoundException,
            TheatreDetailsNotFoundException;
    public MovieTheatre getMovieTheatreDetails(int id) throws MovieTheatreDetailsNotFoundException;
    public boolean deleteMovieTheatre(int id) throws MovieTheatreDetailsNotFoundException;
    public List<MovieTheatre> getAllMovieTheatreDetails();
}
