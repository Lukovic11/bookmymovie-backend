package com.bookmymovie.service;

import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Screening;

import java.time.LocalDate;
import java.util.List;

public interface ScreeningService {

    List<ScreeningDTO> findAll();

    List<ScreeningDTO> findByDate(LocalDate date);

    List<ScreeningDTO> findByMovieId(Long movieId);

    void save(Screening screening);

    void deleteById(Long id);

    void deleteByMovieId(Long movieId);

    void deleteByMovieHallId(Long movieHallId);

    void deleteByDate(LocalDate date);





}
