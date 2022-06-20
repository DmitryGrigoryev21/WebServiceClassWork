package com.gerard.diactivity.controllers;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Getter
@Setter
public class LanguageMovieResponseDTO extends RepresentationModel<LanguageMovieResponseDTO> {

    public String languageUUID;
    public String movieUUID;
    public String title;

}
