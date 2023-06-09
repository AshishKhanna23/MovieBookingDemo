package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTypeDao extends JpaRepository<UserType,Integer> {
    public Optional<UserType> findByUserTypeName(String userTypeName);
}
