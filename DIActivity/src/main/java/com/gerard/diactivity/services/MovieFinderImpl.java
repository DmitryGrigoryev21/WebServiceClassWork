package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.MovieRequestDTO;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.datamapper.MovieRequestMapper;
import com.gerard.diactivity.datamapper.MovieResponseMapper;
import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.entities.MovieRepo;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieFinderImpl implements MovieFinder{

    private final MovieRepo movieRepo;

    @Autowired
    private MovieRequestMapper requestMapper;

    @Autowired
    private MovieResponseMapper responseMapper;

    MovieFinderImpl(MovieRepo movieRepo){this.movieRepo=movieRepo;}

    @Override
    public List<Movie> findAllMovies() {
        return (List<Movie>) movieRepo.findAll();
    }

    @Override
    public MovieResponseDTO findById(int Id) {
        Movie movie = movieRepo.findById(Id).get();
        return responseMapper.entityToModel(movie);
    }

    @Override
    public MovieResponseDTO findByMovieId(String Id) {
        Movie movie = movieRepo.findMovieByMovieId(Id);
        return responseMapper.entityToModel(movie);
    }

    //no need for format validation because it would be done before being passed to api
    @Override
    public MovieResponseDTO saveMovie(MovieRequestDTO movieList) {
        Movie movie = requestMapper.modelToEntity(movieList);
        UUID uuid = UUID.randomUUID();
        movie.setMovieId(uuid.toString());
        System.out.println(movie.getTitle());
        movieRepo.save(movie);
        return responseMapper.entityToModel(movie);
    }

    @Override
    public boolean deleteMovie(int Id) {
        try {
            movieRepo.deleteById(Id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean deleteMovieByMovieId(String Id) {
        if (movieRepo.existsMovieByMovieId(Id)) {
            movieRepo.deleteMovieByMovieId(Id);
            return true;
        }
        else{
            throw new EntityNotFoundException("Invalid MovieId was provided.");
        }
    }

    @Override
    public Movie updateMovie(int Id, Movie newMovie) {
        try {
            Movie movie = movieRepo.findById(Id).get();
            movie.setDirector(newMovie.getDirector());
            movie.setTitle(newMovie.getTitle());
            movieRepo.save(movie);
            return movie;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public MovieResponseDTO updateMovieByMovieId(String Id, Movie newMovie) {
            if (movieRepo.existsMovieByMovieId(Id)) {
                Movie movie = movieRepo.findMovieByMovieId(Id);
                movie.setDirector(newMovie.getDirector());
                movie.setTitle(newMovie.getTitle());
                movieRepo.save(movie);
                return responseMapper.entityToModel(movie);
            }
            else{
                throw new EntityNotFoundException("Invalid MovieId was provided.");
            }
    }
}

