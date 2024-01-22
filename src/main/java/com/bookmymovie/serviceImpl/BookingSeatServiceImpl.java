package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.BookingSeat;
import com.bookmymovie.repository.BookingSeatRepository;
import com.bookmymovie.service.BookingSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingSeatServiceImpl implements BookingSeatService {

    @Autowired
    private BookingSeatRepository bookingSeatRepository;

    @Override
    public List<BookingSeat> findByBookingId(Long bookingId) {
        return bookingSeatRepository.findByBookingId(bookingId);
    }

    @Override
    public void save(BookingSeat bookingSeat) {
        bookingSeatRepository.save(bookingSeat);
    }


}
