package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.SeatRepository;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;

    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }


    @Override
    public List<Seat> findByScreeningId(Long screeningId) {
        return seatRepository.findByScreening_Id(screeningId);
    }

    @Override
    public List<Seat> findByReservedAndScreeningId(boolean reserved, Long screeningId) {
        return seatRepository.findByReservedAndScreening_Id(reserved,screeningId);
    }

    @Override
    public List<Seat> findByIdIn(List<Long> seatIds) {
        return seatRepository.findByIdIn(seatIds);
    }

    @Override
    public void updateSeatAvailability(List<Long> seatIds, boolean reserved) {
        seatRepository.updateSeatAvailability(seatIds,reserved);
    }
}
