package com.bookmymovie.service;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDTO> findAll();

    MovieDTO findById(Long id);

    List<MovieDTO> findByGenre(String genre);

    List<MovieDTO> findByTitle(String title);

    void save(Movie movie);

    void deleteById(Long id);



}
