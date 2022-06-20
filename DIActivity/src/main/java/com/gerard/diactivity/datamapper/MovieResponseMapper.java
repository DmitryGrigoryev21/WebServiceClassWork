package com.gerard.diactivity.datamapper;

import com.gerard.diactivity.controllers.LanguageController;
import com.gerard.diactivity.controllers.LanguageMovieResponseDTO;
import com.gerard.diactivity.controllers.MovieLister;
import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.entities.Movie;
import com.gerard.diactivity.services.LanguageService;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {

    @Mappings({
            @Mapping(expression = "java( movie.getLanguage().getName())", target = "lang"),
    })
    MovieResponseDTO entityToModel(Movie movie);

    @Mapping(target = "id", ignore=true)
    Movie modelToEntity(MovieResponseDTO movieDTO);

    List<MovieResponseDTO> entityListToResponseModelList(List<Movie> movies);

    @AfterMapping
    default void addLinks(@MappingTarget MovieResponseDTO model, Movie entity) {
        Link selfLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(MovieLister.class)
                        .listMoviesByMovieUUID(model.getMovieUUID()))
                .withSelfRel();
        model.add(selfLink);

        Link langLink = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(LanguageController.class)
                        .listLanguagesByLanguageUUID(entity.getLanguage().getLanguageUUID()))
                .withRel("languages");
        model.add(langLink);
    }
}
