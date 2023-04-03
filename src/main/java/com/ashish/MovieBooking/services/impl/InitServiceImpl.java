package com.ashish.MovieBooking.services.impl;

import com.ashish.MovieBooking.dao.*;
import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.City;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.entities.Status;
import com.ashish.MovieBooking.entities.UserType;
import com.ashish.MovieBooking.services.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitServiceImpl implements InitService {

    @Autowired
    private CityService cityService ;

    @Autowired
    private UserTypeDao userTypeDao ;

    @Autowired
    private StatusService statusService ;

    @Autowired
    private MovieService movieService ;

    @Autowired
    private UserDao userDao ;

    @Autowired
    private TheatreDao theatreDao ;

    @Autowired
    private MovieTheatreDao movieTheatreDao ;

    @Autowired
    private BookingDao bookingDao ;


     // Cooking data
      // define and assign at the same time

    List<Status> statuses = Arrays.asList(new Status("UPCOMING") ,
            new Status("RELEASED"),new Status("BLOCKED"));


    @Override
    public void init() {

        //  Writing the logic to store date inside the database in different tables
        // Add cities

        createCities();

        // Add User Types

        createUserTypes();

        //Add Statuses

        createStatuses();

        // Add Movies

        createMovies();

        // Add Users

        // Add Theatres

       // Movie Theatres

       //Booking

    }

    private void createMovies() {
        Movie movie1 = new Movie();
        movie1.setMovieName("Dangal");
        movie1.setStatus(statuses.get(1));
        movie1.setMovieDescription("Good Movie");
        movie1.setDuration(140);
        movie1.setReleaseDate(LocalDateTime.of(2018,4,27,5,30));
        ModelMapper m = new ModelMapper();
        movieService.acceptMovieDetails(m.map(movie1, MovieDto.class));


        Movie movie2 = new Movie();
        movie2.setMovieName("John Wick");
        movie2.setStatus(statuses.get(1));
        movie2.setMovieDescription("Very Good Movie");
        movie2.setDuration(120);
        movie2.setReleaseDate(LocalDateTime.of(2023,3,28,5,00));
        movieService.acceptMovieDetails(m.map(movie2, MovieDto.class));

        Movie movie3 = new Movie();
        movie3.setMovieName("Guardians of the Galaxy Vol.3");
        movie3.setStatus(statuses.get(0));
        movie3.setMovieDescription("NOT KNOWN");
        movie3.setDuration(150);
        movie3.setReleaseDate(LocalDateTime.of(2023,6,28,0,00));
        movieService.acceptMovieDetails(m.map(movie3,MovieDto.class));
    }

    private void createStatuses() {

        statuses.forEach(status -> {
            statusService.acceptStatusDetails(status);
        });
    }

    private void createUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        userTypes.add(new UserType("Customer"));
        userTypes.add(new UserType("Admin"));

        userTypes.forEach(userType ->  {
            userTypeDao.save(userType);
        });
    }

    private void createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Patna"));
        cities.add(new City("Bangalore"));
        cities.add(new City("Kolkata"));
        cities.add(new City("Mumbai"));
        cities.add(new City("Delhi"));

        cities.forEach(city -> cityService.acceptCityDetails(city));
    }
}