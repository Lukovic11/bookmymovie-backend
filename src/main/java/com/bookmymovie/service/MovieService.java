package com.bookmymovie.service;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> findAll();

    List<MovieDTO> findByIsPlayingTrue();

    MovieDTO findById(Long id);

    List<MovieDTO> findByGenre(String genre);

    MovieDTO findByTitle(String title);

    void save(Movie movie);

    void deleteById(Long id);



}
