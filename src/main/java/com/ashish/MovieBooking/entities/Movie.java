package com.ashish.MovieBooking.entities;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId ;

    @Column(length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(name = "movie_desc", length = 500, nullable = false)
    private String movieDescription;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;



}
