package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.BookingRepository;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> findByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteByMovieId(Long movieId) {
        bookingRepository.deleteByMovie_Id(movieId);
    }

    @Override
    public void deleteByUser_Id(Long userId) {
        bookingRepository.deleteByUser_Id(userId);
    }
}
