package com.gerard.diactivity.controllers;

import com.gerard.diactivity.datamapper.MovieResponseMapper;
import com.gerard.diactivity.entities.Language;
import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.services.LanguageService;
import com.gerard.diactivity.services.MovieFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/getlang/all")
    public List<LanguageResponseDTO> listLanguagesAll(){
        return languageService.findAllLanguages();
    }

    @GetMapping("/getlang/languageId/{Id}")
    public LanguageResponseDTO listLanguagesByLanguageUUID(@PathVariable String Id){
        return languageService.findByLanguageUUID(Id);
    }

    @GetMapping("/getlang/languageId/{Id}/movies")
    public List<LanguageMovieResponseDTO> listMoviesByLanguage(@PathVariable String Id){
        return languageService.findMoviesByLanguage(Id);
    }
}
