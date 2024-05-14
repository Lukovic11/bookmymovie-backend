package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.Seat;
import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.repository.MovieHallRepository;
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
    @Autowired
    private MovieHallRepository movieHallRepository;

    @Override
    public SeatDTO findById(Long id) {
        if(id==null){
            throw new BadRequestException("Seat id cannot be null.");
        }
        return seatMapper.seatToSeatDTO(seatRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Seat with the id of "+id+" not found.")));
    }

    @Override
    public List<SeatDTO> findByMovieHallId(Long id) {
        if(id==null){
            throw new BadRequestException("Movie Hall id cannot be null.");
        }
    movieHallRepository.findById(id)
            .orElseThrow(()->new NotFoundException("Movie Hall with the id of "+id+" not found"));
        return seatMapper.toSeatDTOs(seatRepository.findByMovieHall_Id(id).
                orElseThrow(()->new NotFoundException("Seats not found.")));
    }

    @Override
    public void save(Seat seat) {
        if(seat==null){
            throw new BadRequestException("Seat cannot be null.");
        }
        seatRepository.save(seat);
    }

    @Override
    public void deleteByMovieHall_Id(Long movieHallId) {
        if(movieHallId==null){
            throw new BadRequestException("Movie Hall id cannot be null.");
        }
        movieHallRepository.findById(movieHallId)
                .orElseThrow(()->new NotFoundException("Movie Hall with the id of "+movieHallId+" not found"));
        seatRepository.findByMovieHall_Id(movieHallId).
                orElseThrow(()->new NotFoundException("Seats not found."));
        seatRepository.deleteByMovieHall_Id(movieHallId);
    }
}
