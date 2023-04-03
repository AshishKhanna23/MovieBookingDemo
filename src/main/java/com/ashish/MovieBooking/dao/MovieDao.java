package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.Movie;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {

    //If i want to find a movie by movieName:----
    public List<Movie> findByMovieName(String movieName);

    // If i want to find a movie by movieName and Duration (multiple Query) :---
    public List<Movie> findByMovieNameAndDuration(String movieName, int duration);

    // find a movie with duration more than 2 hours:------
    public List<Movie> findByDurationGreaterThanEqual(int duration);

    public List<Movie> findByReleaseDateBetween(LocalDateTime start, LocalDateTime end);

    public List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);

    public List<Movie> findByMovieNameContaining(String movieName);

    public List<Movie> findByMovieNameIgnoreCase(String movieName);

}
