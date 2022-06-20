package com.gerard.diactivity.controllers;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@Getter
@Setter
public class LanguageResponseDTO extends RepresentationModel<LanguageResponseDTO> {

    public String languageUUID;
    public String name;

}
