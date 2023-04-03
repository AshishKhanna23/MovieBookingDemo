package com.ashish.MovieBooking.services.impl;

import com.ashish.MovieBooking.dao.MovieDao;
import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.entities.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

//@SpringBootTest
public class MovieServiceImplUnitTest {

// creating a dummy MovieDao

    @Mock
    private MovieDao movieDao;
    // this creates a movieServiceImpl object with mocked movieDao

    @InjectMocks
    private MovieServiceImpl movieService;

    Movie movie;

    @BeforeEach
    public void beforeTest(){

        movie= new Movie();
        movie.setMovieName("Name1");
        movie.setMovieId(1);
        movie.setMovieDescription("Descp_1");
        movie.setDuration(120);
        movie.setReleaseDate(LocalDateTime.of(2019,12,12,20,40));
        Status status= new Status();
        status.setStatusName("Released");
        movie.setStatus(status);

        // adding the functionality of MovieDao
        // When save method is called, just return the object back
        // It doesn't involve actual calling of the Database

        Mockito.when(movieDao.save(movie)).thenReturn(movie);

    }

    // Test acceptMovieDetails

    @Test
    public void TestAcceptMovieDetails(){
        // Check if this method is able to save a movie detail or not

        ModelMapper modelMapper= new ModelMapper();
        MovieDto savedMovie= movieService.acceptMovieDetails(modelMapper.map(movie,MovieDto.class));

        Assertions.assertNotNull(savedMovie);
        Assertions.assertNotNull(savedMovie.getMovieId());

    }



}
