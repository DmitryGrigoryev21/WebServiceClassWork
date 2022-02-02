package com.gerard.diactivity.entities;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@Setter
@Getter

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String director;

//    public Movie(String title, String director) {
//        this.title = title;
//        this.director = director;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDirector() {
//        return director;
//    }

}