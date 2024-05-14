package com.bookmymovie.repository;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Long> {

    Optional<Screening> findByDateAndTimeAndMovie_Id(LocalDate date, LocalTime time, Long movieId);

    Optional<List<Screening>> findByMovie_Id(Long movieId);

    void deleteByMovie_Id(Long movieId);

    void deleteByMovieHall_Id(Long movieHallId);

    void deleteByDate(LocalDate date);

    boolean existsByMovieAndDate(Movie movie, LocalDate date);



}
