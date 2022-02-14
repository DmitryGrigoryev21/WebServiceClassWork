package com.gerard.diactivity.datamapper;


import com.gerard.diactivity.controllers.MovieResponseDTO;
import com.gerard.diactivity.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieResponseMapper {

    MovieResponseDTO entityToModel(Movie movie);
    @Mapping(target = "id", ignore=true)
    Movie modelToEntity(MovieResponseDTO movieDTO);

    List<MovieResponseDTO> entityListToResponseModelList(List<Movie> movies);
}
