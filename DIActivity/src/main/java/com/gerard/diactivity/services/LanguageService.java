package com.gerard.diactivity.services;

import com.gerard.diactivity.controllers.LanguageMovieResponseDTO;
import com.gerard.diactivity.controllers.LanguageResponseDTO;

import java.util.List;

public interface LanguageService {
    public List<LanguageResponseDTO> findAllLanguages();
    public LanguageResponseDTO findByLanguageUUID(String Id);
    public List<LanguageMovieResponseDTO> findMoviesByLanguage(String Id);
}
