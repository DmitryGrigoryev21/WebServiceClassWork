package com.gerard.diactivity.controllers;

import com.gerard.diactivity.datamapper.MovieResponseMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class MovieResponseDTO extends RepresentationModel<MovieResponseDTO> {

    public String movieUUID;
    public String title;
    public String director;
    public String lang;

}