package com.ashish.MovieBooking.controllers;

import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.exceptions.MovieDetailsNotFoundException;
import com.ashish.MovieBooking.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//Gives hint to Spring that whenever a REST call comes, make sure this class is informed

@RequestMapping("/movies")
// IP address:port number/mbs/v1/movies

public class MovieController {

    @Autowired
    private MovieService movieService;


    // Get all the movies
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(){
        // First, getting list of the movies
        List<MovieDto> movieDtos= movieService.getAllMovieDetails();
        // Wrapping inside the ResponseEntity
        return new ResponseEntity<>(movieDtos, HttpStatus.OK);

    }


    // Getting Movie based on MovieId
    @GetMapping("/{abc}")

    public ResponseEntity<MovieDto> getMovieBasedOnId(@PathVariable(name = "abc") int movieId) throws MovieDetailsNotFoundException {
        return new ResponseEntity<>(movieService.getMovieDetails(movieId), HttpStatus.OK);

    }

    // Creating a new Movie
    @PostMapping
    public ResponseEntity<MovieDto> createMovies(@RequestBody MovieDto movieDto){

        return new ResponseEntity<>(movieService.acceptMovieDetails(movieDto), HttpStatus.CREATED);

    }

    // Updating an existing movie
    @PutMapping(value = "/{movieId}")
    public ResponseEntity updateMovieDetails(@RequestBody MovieDto movieDto, @PathVariable(name = "movieId") int movieId) throws MovieDetailsNotFoundException {
        return new ResponseEntity<>(movieService.updateMovieDetails(movieId, movieDto), HttpStatus.ACCEPTED);
    }

    //Deleting an existing movie
    @DeleteMapping(value = "/{movie_id}")
    public ResponseEntity deleteMovie(@PathVariable(name = "movie_id") int id)
            throws MovieDetailsNotFoundException {
        movieService.deleteMovie(id);
        return new ResponseEntity<>("DELETED", HttpStatus.OK);
    }



}
