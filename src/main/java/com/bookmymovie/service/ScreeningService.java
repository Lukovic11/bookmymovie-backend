package com.bookmymovie.service;

import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.entity.Screening;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScreeningService {

    List<ScreeningDTO> findAll();

    List<ScreeningDTO> findByDateAndMovieId(LocalDate date,Long movieId);

    List<ScreeningDTO> findByMovieId(Long movieId);

    void save(Screening screening);

    void deleteById(Long id);

    void deleteByMovieId(Long movieId);

    void deleteByMovieHallId(Long movieHallId);

    void deleteByDate(LocalDate date);

    boolean existsByMovieHallAndDateAndTime(MovieHall movieHall, LocalDate date, LocalTime time);

    boolean existsByMovieAndDate(Movie movie, LocalDate date);
}
