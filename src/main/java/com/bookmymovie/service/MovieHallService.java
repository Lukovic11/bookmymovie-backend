package com.bookmymovie.service;

import com.bookmymovie.entity.MovieHall;

import java.util.List;

public interface MovieHallService {

    List<MovieHall> findAll();

    void save(MovieHall movieHall);

    void deleteById(Long id);

}
