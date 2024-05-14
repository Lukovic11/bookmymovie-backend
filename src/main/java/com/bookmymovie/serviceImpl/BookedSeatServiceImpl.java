package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.BookedSeat;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.repository.BookedSeatRepository;
import com.bookmymovie.repository.BookingRepository;
import com.bookmymovie.repository.SeatRepository;
import com.bookmymovie.service.BookedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookedSeatServiceImpl implements BookedSeatService {

    @Autowired
    private BookedSeatRepository bookedSeatRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Override
    public List<BookedSeat> findByBookingId(Long bookingId) {
        if(bookingId==null){
            throw new BadRequestException("Booking id cannot be null.");
        }
        return bookedSeatRepository.findByBookingId(bookingId).orElseThrow(()->new NotFoundException("Booking not found."));
    }

    @Override
    public List<BookedSeat> findBySeatId(Long seatId) {
        if(seatId==null){
            throw new BadRequestException("Seat id cannot be null.");
        }
        return bookedSeatRepository.findBySeatId(seatId).orElseThrow(()->new NotFoundException("Seat not found."));
    }

    @Override
    public void save(BookedSeat bookedSeat) {
        if(bookedSeat.getBookingId()==null || bookedSeat.getSeatId()==null){
            throw new BadRequestException("Booking and seat ids cannot be null.");
        }
        bookingRepository.findById(bookedSeat.getBookingId()).orElseThrow(()->new NotFoundException("Booking not found."));
        seatRepository.findById(bookedSeat.getSeatId()).orElseThrow(()->new NotFoundException("Seat not found"));
        bookedSeatRepository.save(bookedSeat);
    }

}
