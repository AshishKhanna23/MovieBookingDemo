package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.Movie;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    //To find all the movies
    public List<Movie> findAll();

    //To find a movie by movieName:----
    public List<Movie> findByMovieName(String movieName);

    //To find a movie by movieName and Duration (multiple Query) :---
    public List<Movie> findByMovieNameAndDuration(String movieName, int duration);

    public List<Movie> findByMovieNameIgnoreCase(String movieName);

}
