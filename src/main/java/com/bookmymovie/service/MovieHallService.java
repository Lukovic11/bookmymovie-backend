package com.bookmymovie.service;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;

import java.util.List;

public interface MovieHallService {

    List<MovieHallDTO> findAll();

    void save(MovieHall movieHall);

    void deleteById(Long id);

}
