package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.BookingRepository;
import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.mapper.BookingMapper;
import com.bookmymovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public List<BookingDTO> findAll() {
        return bookingMapper.toBookingDTOs(bookingRepository.findAll());
    }

    @Override
    public List<BookingDTO> findByUserId(Long userId) {
        return bookingMapper.toBookingDTOs(bookingRepository.findByUserId(userId));
    }

    @Override
    public List<BookingDTO> findByScreening_Id(Long screeningId) {
        return bookingMapper.toBookingDTOs(bookingRepository.findByScreening_Id(screeningId));
    }

    @Override
    public void save(Booking booking) {
        System.out.println(booking);
        bookingRepository.save(booking);
    }

    @Override
    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteByScreening_Id(Long screeningId) {
        bookingRepository.deleteByScreening_Id(screeningId);
    }

    @Override
    public void deleteByUser_Id(Long userId) {
        bookingRepository.deleteByUser_Id(userId);
    }
}
