package com.ashish.MovieBooking.entities;

import lombok.Data;

import java.time.LocalDateTime;
import javax.persistence.*;

@Data
@Entity
@Table(name = "`movie`")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`movie_Id`")
    private int movieId ;

    @Column(name = "`movie_name`",length = 50, nullable = false, unique = true)
    private String movieName;

    @Column(name = "`movie_description`", length = 500, nullable = false)
    private String movieDescription;

    @Column(name = "`release_date`",nullable = false)
    private LocalDateTime releaseDate;

    @Column(name = "`duration`",nullable = false)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "`status_id`", nullable = false)
    private Status status;

    @Column(name = "`is_active`")
    private boolean isActive= true;


}
