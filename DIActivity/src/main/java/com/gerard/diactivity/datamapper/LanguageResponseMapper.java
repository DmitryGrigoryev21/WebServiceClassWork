package com.gerard.diactivity.datamapper;

import com.gerard.diactivity.controllers.*;
import com.gerard.diactivity.entities.Language;
import com.gerard.diactivity.entities.Movie;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageResponseMapper {
    LanguageResponseDTO entityToModel(Language language);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "movies", ignore = true)
    })
    Language modelToEntity(LanguageResponseDTO languageDTO);

    List<LanguageResponseDTO> entityListToResponseModelList(List<Language> languages);

    @AfterMapping
    default void addLinks(@MappingTarget LanguageResponseDTO model, Language entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .listLanguagesByLanguageUUID(model.getLanguageUUID()))
                .withSelfRel();
        model.add(selfLink);

        Link movieLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieLister.class)
                        .listMoviesByLanguage(entity.getName()))
                .withRel("movies");
        model.add(movieLink);
    }
}


