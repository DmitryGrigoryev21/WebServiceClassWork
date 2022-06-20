package com.gerard.diactivity.datamapper;

import com.gerard.diactivity.controllers.MovieRequestDTO;
import com.gerard.diactivity.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MovieRequestMapper {

    MovieRequestDTO entityToModel(Movie movie);
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "movieUUID", ignore = true)
    })
    Movie modelToEntity(MovieRequestDTO movieDTO);

}
