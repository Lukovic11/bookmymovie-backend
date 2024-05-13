package com.bookmymovie.service;

import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.Screening;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScreeningService {

    List<ScreeningDTO> findAll();

    List<ScreeningDTO> findByMovieId(Long movieId);

    ScreeningDTO findByDateAndTimeAndMovie_Id(LocalDate date,LocalTime time, Long movieId);

    void save(Screening screening);

    void deleteAllInBatch();

    void deleteById(Long id);

    void deleteByMovieId(Long movieId);

    void deleteByMovieHallId(Long movieHallId);

    void deleteByDate(LocalDate date);

    void generateScreeningsForNext3Months();

    boolean existsByMovieAndDate(Movie movie, LocalDate date);
}
