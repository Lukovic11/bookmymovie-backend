package com.bookmymovie.service;


import com.bookmymovie.entity.BookedSeat;

import java.util.List;

public interface BookedSeatService {

    List<BookedSeat> findByBookingId(Long bookingId);
    List<BookedSeat> findBySeatId(Long seatId);
    void save(BookedSeat bookedSeat);
}
