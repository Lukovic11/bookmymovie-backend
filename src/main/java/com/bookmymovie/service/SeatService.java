package com.bookmymovie.service;

import com.bookmymovie.entity.Seat;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatService {

    List<Seat> findByScreeningId(Long screeningId);

    List<Seat> findByReservedAndScreeningId(boolean reserved, Long screeningId);

    List<Seat> findByIdIn(List<Long> seatIds);

    void updateSeatAvailability(List<Long> seatIds, boolean reserved);




}
