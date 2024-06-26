package com.bookmymovie.repository;

import com.bookmymovie.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    Optional<List<Seat>> findByMovieHall_Id(Long movieHallId);

    void deleteByMovieHall_Id(Long movieHallId);


}
