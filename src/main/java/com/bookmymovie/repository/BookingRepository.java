package com.bookmymovie.repository;

import com.bookmymovie.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    List<Booking> findByUserId(Long userId);

    void deleteByScreening_Id(Long screeningId);

    void deleteByUser_Id(Long userId);



}
