package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.Seat;
import com.bookmymovie.repository.SeatRepository;
import com.bookmymovie.dto.SeatDTO;
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
    public List<SeatDTO> findByMovieHallId(Long id) {
        return seatMapper.toSeatDTOs(seatRepository.findByMovieHall_Id(id));
    }

    @Override
    public void save(Seat seat) {
        seatRepository.save(seat);
    }

    @Override
    public void deleteByMovieHall_Id(Long movieHallId) {
        seatRepository.deleteByMovieHall_Id(movieHallId);
    }
}
