package com.gerard.diactivity.services;

import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.entities.MovieRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieFinderImpl implements MovieFinder{

    private final MovieRepo movieRepo;

    MovieFinderImpl(MovieRepo movieRepo){this.movieRepo=movieRepo;}

    @Override
    public List<Movie> findAllMovies() {
        return (List<Movie>) movieRepo.findAll();
    }

    @Override
    public Optional<Movie> findById(int Id) {
        return movieRepo.findById(Id);
    }

    //no need for format validation because it would be done before being passed to api
    @Override
    public List<Movie> saveAllMovies(List<Movie> movieList) {
        return (List<Movie>) movieRepo.saveAll(movieList);
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

