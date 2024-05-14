package com.bookmymovie.repository;

import com.bookmymovie.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    Optional<List<Booking>> findByUserId(Long userId);

    Optional<List<Booking>> findByScreening_Id(Long screeningId);

    void deleteByScreening_Id(Long screeningId);

    void deleteByUser_Id(Long userId);



}
