package com.bookmymovie.dao;

import com.bookmymovie.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening,Long> {

    List<Screening> findByDate(LocalDate date);

    List<Screening> findByMovie_Id(Long id);

    void deleteByMovie_Id(Long id);

    void deleteByMovieHall_Id(Long id);

    void deleteByDate(LocalDate date);



}
