package com.gerard.diactivity.services;

import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.entities.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieFinderImpl implements MovieFinder{

    private MovieRepo movieRepo;

    MovieFinderImpl(MovieRepo movieRepo){this.movieRepo=movieRepo;}

    @Override
    public List<Movie> findAllMovies() {
        List<Movie> movies = (List<Movie>) movieRepo.findAll();
        return movies;
    }

    @Override
    public Optional<Movie> findById(int Id) {
        Optional<Movie> movie = movieRepo.findById(Id);
        return movie;
    }

    @Override
    public List<Movie> saveAllMovies(List<Movie> movieList) {
        List<Movie> movieResponse = (List<Movie>) movieRepo.saveAll(movieList);
        return movieResponse;
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

    @Override
    public boolean updateMovie(int Id, Movie newMovie) {
        try {
            Movie movie = movieRepo.findById(Id).get();
            movie.setDirector(newMovie.getDirector());
            movie.setTitle(newMovie.getTitle());
            movieRepo.save(movie);
            return true;
        }
        catch (Exception e){
            return false;
        }


    }
}

