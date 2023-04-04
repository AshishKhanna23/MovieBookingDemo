package com.ashish.MovieBooking.services.impl;

import com.ashish.MovieBooking.dao.MovieDao;
import com.ashish.MovieBooking.dtos.MovieDto;
import com.ashish.MovieBooking.entities.Movie;
import com.ashish.MovieBooking.exceptions.MovieDetailsNotFoundException;
import com.ashish.MovieBooking.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.ashish.MovieBooking.converters.MovieConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    //To talk with the database:
    @Autowired
    private MovieDao movieDao;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    MovieConverter movieConverter;


    @Override
    public List<MovieDto> getAllMovieDetails() {
        List<MovieDto> movieDtos= new ArrayList<>();
        List<Movie> movies= movieDao.findAll();
        for (Movie movie : movies){
            movieDtos.add(movieConverter.ConvertToMovieDto(movie));
        }
        return movieDtos;
    }

    @Override
    public MovieDto getMovieDetails(int id) throws MovieDetailsNotFoundException {
        Movie movie= movieDao.findById(id).orElseThrow(()-> new MovieDetailsNotFoundException("Movie not found"));
        return movieConverter.ConvertToMovieDto(movie);
    }

    @Override
    public MovieDto updateMovieDetails(int id, MovieDto movie) throws MovieDetailsNotFoundException {
        // updating the movie
        Movie savedMovie= movieDao.findById(id).orElseThrow(()-> new MovieDetailsNotFoundException("Movie not found"));

        //read the movie attributes from the movie object and  update it in savedMovie
        if(isNotNullOrZero(movie.getMovieName() )) {
            savedMovie.setMovieName(movie.getMovieName());
        }
        if (isNotNullOrZero(movie.getMovieDescription() )) {
            savedMovie.setMovieDescription(movie.getMovieDescription());
        }
        if(isNotNullOrZero(movie.getDuration())){
            savedMovie.setDuration(movie.getDuration());
        }
        if (isNotNullOrZero(movie.getReleaseDate())){
            savedMovie.setReleaseDate(movie.getReleaseDate());
        }
        Movie saved_movie = movieDao.save(savedMovie);
        return movieConverter.ConvertToMovieDto(saved_movie);

    }

    private boolean isNotNullOrZero(Object obj){
        return obj!= null;
    }

    @Override
    public MovieDto acceptMovieDetails(MovieDto movieDto) {
        Movie movie = movieConverter.ConvertToMovie(movieDto);
        Movie saved_movie = movieDao.save(movie);
        return movieConverter.ConvertToMovieDto(saved_movie);
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        MovieDto savedMovie= getMovieDetails(id);
        movieDao.delete(movieConverter.ConvertToMovie(savedMovie));
        return true;
    }


    @Override
    public boolean deleteMovieNot(int id) throws MovieDetailsNotFoundException {
        Movie movie= movieDao.findById(id).orElseThrow(()-> new MovieDetailsNotFoundException("Movie not found"));
        movie.setActive(false);
        movieDao.save(movie);
        return true;


    }


}
