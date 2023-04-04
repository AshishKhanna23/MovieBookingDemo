package com.ashish.MovieBooking.converters;

import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter {

    @Autowired
    ModelMapper modelMapper;

    public MovieDto ConvertToMovieDto(Movie movie){
        MovieDto movieDto= modelMapper.map(movie,MovieDto.class);
        return movieDto;
    }
    public Movie ConvertToMovie(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        return movie;
    }

}
