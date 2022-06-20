package com.gerard.diactivity.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Integer> {
    public Movie findMovieByMovieUUID(String movieUUID);
    public List<Movie> findAllByLanguage_Name(String language);
    public boolean existsMovieByMovieUUID(String movieUUID);
    public void deleteMovieByMovieUUID(String movieUUID);
}
