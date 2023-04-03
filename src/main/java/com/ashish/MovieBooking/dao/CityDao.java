package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {

    public City findByCityName(String cityName);
}
