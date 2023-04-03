package com.ashish.MovieBooking.services;

// This will be used to initialize the data in all the tables in MovieBooking

import com.ashish.MovieBooking.exceptions.*;

public interface InitService {

    // This method when called will initialize the data in DB

    public void init() throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException,
            TheatreDetailsNotFoundException, MovieDetailsNotFoundException,
            MovieTheatreDetailsNotFoundException, UserDetailsNotFoundException;


}
