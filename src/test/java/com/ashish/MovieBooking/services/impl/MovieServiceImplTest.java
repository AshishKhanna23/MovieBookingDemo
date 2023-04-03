package com.ashish.MovieBooking.services.impl;

// This class will test MovieServiceImpl class

import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.entities.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

//@SpringBootTest
public class MovieServiceImplTest {

    @Autowired
    private MovieServiceImpl movieService;

    @Autowired
    private StatusServiceImpl statusService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){

        movie= new Movie();
        movie.setMovieName("Name1");
        movie.setMovieDescription("Descp_1");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2019,12,12,20,40));
        Status status= new Status();
        status.setStatusName("Released");
        statusService.acceptStatusDetails(status);
        movie.setStatus(status);
    }

    // Test acceptMovieDetails

    @Test
    public void TestAcceptMovieDetails(){
        // Check if this method is able to save a movie detail or not

        ModelMapper modelMapper= new ModelMapper();
        MovieDto savedMovie= movieService.acceptMovieDetails(modelMapper.map(movie, MovieDto.class));

        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getMovieId());

    }

    // Test getMovieDetails

    // Test updateMovieDetails

    // Test deleteMovie

    // Test getAllMovieDetails

}


