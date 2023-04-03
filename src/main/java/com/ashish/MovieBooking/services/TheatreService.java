package com.ashish.MovieBooking.services;

import com.ashish.MovieBooking.entities.Theatre;
import com.ashish.MovieBooking.exceptions.TheatreDetailsNotFoundException;

import java.util.List;

public interface TheatreService {

    public Theatre acceptTheatreDetails(Theatre theatre);
    public Theatre getTheatreDetails(int id) throws TheatreDetailsNotFoundException;
    public Theatre updateTheatreDetails(int id, Theatre theatre) throws TheatreDetailsNotFoundException;
    public boolean deleteTheatre(int id) throws TheatreDetailsNotFoundException;
    public List<Theatre> getAllTheatreDetails();
}
