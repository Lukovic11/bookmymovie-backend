package com.bookmymovie.service;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDTO> findAll();

    Optional<Movie> findById(Long id);

    List<Movie> findByGenre(String genre);

    List<Movie> findByTitle(String title);

    void save(Movie movie);

    void deleteById(Long id);



}
