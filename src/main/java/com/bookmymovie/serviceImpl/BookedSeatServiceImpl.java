package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.BookedSeat;
import com.bookmymovie.repository.BookedSeatRepository;
import com.bookmymovie.service.BookedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSeatServiceImpl implements BookedSeatService {

    @Autowired
    private BookedSeatRepository bookedSeatRepository;

    @Override
    public List<BookedSeat> findByBookingId(Long bookingId) {
        return bookedSeatRepository.findByBookingId(bookingId);
    }

    @Override
    public List<BookedSeat> findBySeatId(Long seatId) {
        return bookedSeatRepository.findBySeatId(seatId);
    }

    @Override
    public void save(BookedSeat bookedSeat) {
        bookedSeatRepository.save(bookedSeat);
    }


}
