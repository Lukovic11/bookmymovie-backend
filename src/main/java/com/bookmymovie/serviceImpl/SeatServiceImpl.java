package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.SeatRepository;
import com.bookmymovie.dto.SeatDTO;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.mapper.SeatMapper;
import com.bookmymovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private SeatMapper seatMapper;


    @Override
    public List<SeatDTO> findByScreeningId(Long screeningId) {
        List<SeatDTO> seats=seatMapper.toSeatDTOs(seatRepository.findByScreening_Id(screeningId));
        return seats;
    }

    @Override
    public List<SeatDTO> findByReservedAndScreeningId(boolean reserved, Long screeningId) {
        List<SeatDTO> seats=seatMapper.toSeatDTOs(seatRepository.findByReservedAndScreening_Id(reserved,screeningId));
        return seats;
    }

    @Override
    public List<SeatDTO> findByIdIn(List<Long> seatIds) {
        List<SeatDTO> seats=seatMapper.toSeatDTOs(seatRepository.findByIdIn(seatIds));
        return seats;
    }

    @Override
    public void updateSeatAvailability(List<Long> seatIds, boolean reserved) {
        seatRepository.updateSeatAvailability(seatIds,reserved);
    }
}
