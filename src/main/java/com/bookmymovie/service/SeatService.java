package com.bookmymovie.service;

import com.bookmymovie.dto.SeatDTO;
import com.bookmymovie.entity.Seat;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatService {

    List<SeatDTO> findByScreeningId(Long screeningId);

    List<SeatDTO> findByReservedAndScreeningId(boolean reserved, Long screeningId);

    List<SeatDTO> findByIdIn(List<Long> seatIds);

    void updateSeatAvailability(List<Long> seatIds, boolean reserved);




}
