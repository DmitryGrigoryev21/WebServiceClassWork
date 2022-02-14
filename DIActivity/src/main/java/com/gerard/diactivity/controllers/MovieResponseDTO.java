package com.gerard.diactivity.controllers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.UUID;

@NoArgsConstructor
@Setter
@Getter
public class MovieResponseDTO {

    public String movieId;
    public String title;
    public String director;

}