package com.ashish.MovieBooking.dao;

import com.ashish.MovieBooking.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusDao extends JpaRepository<Status,Integer> {
    public Status findByStatusName(String statusName);
}
