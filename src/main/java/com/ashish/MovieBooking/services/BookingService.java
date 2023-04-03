package com.ashish.MovieBooking.services;

import com.ashish.MovieBooking.entities.Booking;
import com.ashish.MovieBooking.exceptions.BookingDetailsNotFoundException;
import com.ashish.MovieBooking.exceptions.MovieTheatreDetailsNotFoundException;
import com.ashish.MovieBooking.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {

    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;

    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;

    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;

    public List<Booking> getAllBookingDetails();
}
