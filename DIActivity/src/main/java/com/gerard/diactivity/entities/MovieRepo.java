package com.gerard.diactivity.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {
    public Movie findMovieByMovieId(String movieId);
    public boolean existsMovieByMovieId(String movieId);
    public void deleteMovieByMovieId(String movieId);
}
