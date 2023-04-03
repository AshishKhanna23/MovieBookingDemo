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

    @Override
    public MovieDto acceptMovieDetails(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        Movie saved_movie = movieDao.save(movie);

        return modelMapper.map(saved_movie, MovieDto.class);
    }

    @Override
    public MovieDto getMovieDetails(int id) throws MovieDetailsNotFoundException {
        Movie movie= movieDao.findById(id).orElseThrow(()-> new MovieDetailsNotFoundException("Movie not found"));


        //convert movie object to movieDto Object
        MovieDto movieDto= convertToMovieDto(movie);
        return movieDto;
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

        return modelMapper.map(saved_movie, MovieDto.class);

    }

    private boolean isNotNullOrZero(Object obj){
        return obj!= null;
    }

    @Override
    public boolean deleteMovie(int id) throws MovieDetailsNotFoundException {
        MovieDto savedMovie= getMovieDetails(id);
        movieDao.delete(modelMapper.map(savedMovie, Movie.class));
        return true;
    }

    @Override
    public List<MovieDto> getAllMovieDetails() {
        List<MovieDto> movieDtos= new ArrayList<>();
        try {
            List<Movie> movies = movieDao.findAll();
            for (Movie movie : movies){
                movieDtos.add(convertToMovieDto(movie));
            }
        } catch (Exception e) {

        }
        return movieDtos;
    }

    private MovieDto convertToMovieDto(Movie movie){
        MovieDto movieDto= modelMapper.map(movie,MovieDto.class);
        return movieDto;
    }
}
