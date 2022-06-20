package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.LanguageMovieResponseDTO;
import com.gerard.diactivity.controllers.LanguageResponseDTO;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.datamapper.LanguageMovieResponseMapper;
import com.gerard.diactivity.datamapper.LanguageResponseMapper;
import com.gerard.diactivity.datamapper.MovieRequestMapper;
import com.gerard.diactivity.datamapper.MovieResponseMapper;
import com.gerard.diactivity.entities.Language;
import com.gerard.diactivity.entities.LanguageRepo;
import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.entities.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class LanguageServiceImpl implements LanguageService{

    private final LanguageRepo languageRepo;

    @Autowired
    private LanguageResponseMapper languageResponseMapper;

    @Autowired
    private LanguageMovieResponseMapper languageMovieResponseMapper;

    LanguageServiceImpl(LanguageRepo languageRepo){this.languageRepo=languageRepo;}

    @Override
    public List<LanguageResponseDTO> findAllLanguages() {

        List<Language> temp = (List<Language>) languageRepo.findAll();
        List<LanguageResponseDTO> tempo = languageResponseMapper.entityListToResponseModelList(temp);
        return tempo;
    }

    @Override
    public LanguageResponseDTO findByLanguageUUID(String Id) {
        Language language = languageRepo.findLanguageByLanguageUUID(Id);
        return languageResponseMapper.entityToModel(language);
    }

    @Override
    public List<LanguageMovieResponseDTO> findMoviesByLanguage(String Id) {
        Language language = languageRepo.findLanguageByLanguageUUID(Id);
        Set<Movie> movieSet= language.getMovies();
        List<Movie> movieList = new ArrayList<>(movieSet);
        List<LanguageMovieResponseDTO> movieListResponse = languageMovieResponseMapper.entityListToResponseModelList(movieList);
        return movieListResponse;
    }


}
