package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="movie")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    @Id //defining a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // defining how we generate primary key value (identity=auto increment)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "yearofrelease")
    private Long yearOfRelease;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "language")
    private String language;

    @Column(name = "countryoforigin")
    private String countryOfOrigin;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "poster")
    private String poster;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "isplaying")
    private Boolean isPlaying;

}