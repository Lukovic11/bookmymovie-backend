package com.bookmymovie.service;


import com.bookmymovie.entity.BookedSeat;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.entity.Seat;

import java.util.List;
import java.util.Optional;

public interface BookedSeatService {

    List<BookedSeat> findByBookingId(Long bookingId);

    List<BookedSeat> findBySeatId(Long seatId);

    void save(BookedSeat bookedSeat);

}
