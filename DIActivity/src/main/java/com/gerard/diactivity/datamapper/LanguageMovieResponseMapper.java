package com.gerard.diactivity.datamapper;

import com.gerard.diactivity.controllers.*;
import com.gerard.diactivity.entities.Language;
import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.services.LanguageService;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMovieResponseMapper {

    @Mappings({
            @Mapping(expression = "java(movie.getLanguage().getLanguageUUID())", target = "languageUUID"),
    })
    LanguageMovieResponseDTO entityToModel(Movie movie);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "director", ignore = true)
    })
    Movie modelToEntity(LanguageMovieResponseDTO languageMovieDTO);

    List<LanguageMovieResponseDTO> entityListToResponseModelList(List<Movie> movies);

    @AfterMapping
    default void addLinks(@MappingTarget LanguageMovieResponseDTO model, Movie entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .listLanguagesByLanguageUUID(model.getLanguageUUID()))
                .withSelfRel();
        model.add(selfLink);

        Link movieLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieLister.class)
                        .listMoviesByMovieUUID(entity.getMovieUUID()))
                .withRel("movies");
        model.add(movieLink);
    }
}
