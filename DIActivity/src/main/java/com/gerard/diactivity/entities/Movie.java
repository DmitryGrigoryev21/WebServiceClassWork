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

    @Column(unique = true, name = "movieuuid")
    String movieUUID;

    String title;
    String director;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "languageuuid", nullable = false)
    private Language language;

}