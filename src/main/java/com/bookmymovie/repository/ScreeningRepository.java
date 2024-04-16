package com.bookmymovie.repository;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Long> {

    Screening findByDateAndTimeAndMovie_Id(LocalDate date,LocalTime time, Long movieId);

//    @Query("SELECT s FROM Screening s JOIN FETCH s.movie WHERE  s.movie.id=:movieId")
    List<Screening> findByMovie_Id(Long movieId);

    void deleteByMovie_Id(Long movieId);

    void deleteByMovieHall_Id(Long movieHallId);

    void deleteByDate(LocalDate date);

    boolean existsByMovieHallAndDateAndTime(MovieHall movieHall, LocalDate date, LocalTime time);

    boolean existsByMovieAndDate(Movie movie, LocalDate date);



}
