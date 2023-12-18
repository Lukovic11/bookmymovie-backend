package com.bookmymovie.repository;

import com.bookmymovie.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Long> {

    List<Screening> findByDate(LocalDate date);

//    @Query("SELECT s FROM Screening s JOIN FETCH s.movie WHERE  s.movie.id=:movieId")
    List<Screening> findByMovie_Id(Long movieId);

    void deleteByMovie_Id(Long movieId);

    void deleteByMovieHall_Id(Long movieHallId);

    void deleteByDate(LocalDate date);



}
