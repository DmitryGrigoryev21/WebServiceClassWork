package com.gerard.diactivity.controllers;

import com.gerard.diactivity.datamapper.MovieRequestMapper;
import com.gerard.diactivity.datamapper.MovieResponseMapper;
import com.gerard.diactivity.services.MovieFinder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
public class MovieRequestDTO {

    public String title;
    public String director;

}