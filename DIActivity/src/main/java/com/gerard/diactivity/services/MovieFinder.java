package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.MovieRequestDTO;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieFinder {

    public List<MovieResponseDTO> findAllMovies();
    public MovieResponseDTO findById(int Id);
    public MovieResponseDTO findByMovieUUID(String Id);
    public List<MovieResponseDTO> findByLanguage(String language);
    public MovieResponseDTO saveMovie(MovieRequestDTO movieList);
    public boolean deleteMovie(int Id);
    public boolean deleteMovieByMovieUUID(String Id);
    public Movie updateMovie(int Id, Movie newMovie);
    public MovieResponseDTO updateMovieByMovieUUID(String Id, MovieRequestDTO newMovie);
}
