package com.gerard.diactivity.services;

import com.gerard.diactivity.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieFinder {

    public List<Movie> findAllMovies();
    public Optional<Movie> findById(int Id);
    public List<Movie> saveAllMovies(List<Movie> movieList);
    public boolean deleteMovie(int Id);
    public boolean updateMovie(int Id, Movie newMovie);

}
