package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.MovieRequestDTO;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieFinder {

    public List<Movie> findAllMovies();
    public MovieResponseDTO findById(int Id);
    public MovieResponseDTO findByMovieId(String Id);
    public MovieResponseDTO saveMovie(MovieRequestDTO movieList);
    public boolean deleteMovie(int Id);
    public boolean deleteMovieByMovieId(String Id);
    public Movie updateMovie(int Id, Movie newMovie);
    public MovieResponseDTO updateMovieByMovieId(String Id, Movie newMovie);
}
