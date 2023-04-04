package com.ashish.MovieBooking.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

// this class will be used to convert client JSON request to Java Object and vice-versa

@Data
public class MovieDto {

    @JsonProperty("movie_id")
    private int movieId ;

    private String movieName;

    private String movieDescription;

    private LocalDateTime releaseDate;

    private int duration;

    private int statusId;

    private boolean isActive;

}
