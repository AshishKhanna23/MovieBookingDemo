package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.MovieTheatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheatreDao extends JpaRepository<MovieTheatre,Integer> {
}
