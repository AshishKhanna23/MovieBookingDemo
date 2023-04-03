package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking,Integer> {
}
