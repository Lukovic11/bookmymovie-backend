package com.bookmymovie.service;


import com.bookmymovie.entity.BookingSeat;

import java.util.List;

public interface BookingSeatService {

    List<BookingSeat> findByBookingId(Long bookingId);
    void save(BookingSeat bookingSeat);
}
