package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.MovieRequestDTO;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.datamapper.LanguageMovieResponseMapper;
import com.gerard.diactivity.datamapper.LanguageResponseMapper;
import com.gerard.diactivity.datamapper.MovieRequestMapper;
import com.gerard.diactivity.datamapper.MovieResponseMapper;
import com.gerard.diactivity.entities.Language;
import com.gerard.diactivity.entities.LanguageRepo;
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
    private final LanguageRepo languageRepo;

    @Autowired
    private MovieRequestMapper requestMapper;

    @Autowired
    private MovieResponseMapper responseMapper;

    MovieFinderImpl(MovieRepo movieRepo, LanguageRepo languageRepo){
        this.movieRepo=movieRepo;
        this.languageRepo=languageRepo;
    }


    @Override
    public List<MovieResponseDTO> findAllMovies() {

        List<Movie> movies = (List<Movie>) movieRepo.findAll();
        List<MovieResponseDTO> moviesResponse = responseMapper.entityListToResponseModelList(movies);
        return moviesResponse;
    }

    @Override
    public MovieResponseDTO findById(int Id) {
        Movie movie = movieRepo.findById(Id).get();
        return responseMapper.entityToModel(movie);
    }

    @Override
    public MovieResponseDTO findByMovieUUID(String Id) {
        Movie movie = movieRepo.findMovieByMovieUUID(Id);
        return responseMapper.entityToModel(movie);
    }

    public List<MovieResponseDTO> findByLanguage(String language){
        List<Movie> movies = (List<Movie>) movieRepo.findAllByLanguage_Name(language);
        List<MovieResponseDTO> moviesResponse = responseMapper.entityListToResponseModelList(movies);
        return moviesResponse;
    }

    //no need for format validation because it would be done before being passed to api
    @Override
    public MovieResponseDTO saveMovie(MovieRequestDTO movieList) {
        Movie movie = requestMapper.modelToEntity(movieList);
        UUID uuid = UUID.randomUUID();
        movie.setMovieUUID(uuid.toString());
        if(!languageRepo.existsLanguageByName(movieList.getLang())){
            Language temp= new Language();
            temp.setName(movieList.getLang());
            UUID uuid1 = UUID.randomUUID();
            temp.setLanguageUUID(uuid1.toString());
            languageRepo.save(temp);
        }
        movie.setLanguage(languageRepo.findLanguageByName(movieList.getLang()));
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
    public boolean deleteMovieByMovieUUID(String Id) {
        if (movieRepo.existsMovieByMovieUUID(Id)) {
            movieRepo.deleteMovieByMovieUUID(Id);
            return true;
        }
        else{
            throw new EntityNotFoundException("Invalid movieUUID was provided.");
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
    public MovieResponseDTO updateMovieByMovieUUID(String Id, MovieRequestDTO newMovie) {
            if (movieRepo.existsMovieByMovieUUID(Id)) {
                Movie movie = movieRepo.findMovieByMovieUUID(Id);
                Movie movieTemp = requestMapper.modelToEntity(newMovie);
                movie.setDirector(movieTemp.getDirector());
                movie.setTitle(movieTemp.getTitle());
                if(!languageRepo.existsLanguageByName(newMovie.getLang())){
                    Language temp= new Language();
                    temp.setName(newMovie.getLang());
                    UUID uuid1 = UUID.randomUUID();
                    temp.setLanguageUUID(uuid1.toString());
                    languageRepo.save(temp);
                }
                movie.setLanguage(languageRepo.findLanguageByName(newMovie.getLang()));
                movieRepo.save(movie);
                return responseMapper.entityToModel(movie);
            }
            else{
                throw new EntityNotFoundException("Invalid movieUUID was provided.");
            }
    }
}

