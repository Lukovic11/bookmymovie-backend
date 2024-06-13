package com.bookmymovie.serviceImpl;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.repository.BookingRepository;
import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.mapper.BookingMapper;
import com.bookmymovie.repository.MovieRepository;
import com.bookmymovie.repository.ScreeningRepository;
import com.bookmymovie.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScreeningRepository screeningRepository;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<BookingDTO> findAll() {
        return bookingMapper.toBookingDTOs(bookingRepository.findAll());
    }

    @Override
    public List<BookingDTO> findByUserId(Long userId) {
        if(userId==null){
            throw new BadRequestException("User id cannot be null.");
        }
        userRepository.findById(userId).orElseThrow(()->new NotFoundException("User not found."));
        return bookingMapper.toBookingDTOs(bookingRepository.findByUserId(userId).
                orElseThrow(()->new NotFoundException("Booking not found.")));
    }

    @Override
    public List<BookingDTO> findByScreening_Id(Long screeningId) {
        if(screeningId==null){
            throw new BadRequestException("Screening id cannot be null.");
        }
        screeningRepository.findById(screeningId).orElseThrow(()->new NotFoundException("Screening not found."));
        return bookingMapper.toBookingDTOs(bookingRepository.findByScreening_Id(screeningId)
                .orElseThrow(()->new NotFoundException("Booking not found.")));
    }

    @Override
    public void save(Booking booking) {
        if(booking.getScreening()==null || booking.getCreatedOn()==null||
        booking.getNumOfSeats()==null || booking.getSeats()==null){
            throw new BadRequestException("Booking info cannot be null");
        }
        if(booking.getUser()==null){
            throw new BadRequestException("Anonymous user cannot book tickets.");
        }
        bookingRepository.save(booking);
    }

    @Override
    public void deleteById(Long id) {
        if(id==null){
            throw new BadRequestException("Booking id cannot be null.");
        }
        bookingRepository.findById(id).orElseThrow(()->new NotFoundException("Booking not found."));
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteByScreening_Id(Long screeningId) {
        if(screeningId==null){
            throw new BadRequestException("Screening id cannot be null.");
        }
        screeningRepository.findById(screeningId).orElseThrow(()->new NotFoundException("Screening not found."));
        bookingRepository.findByScreening_Id(screeningId).orElseThrow(()->new NotFoundException("Booking not found."));
        bookingRepository.deleteByScreening_Id(screeningId);
    }

    @Override
    public void deleteByUser_Id(Long userId) {
        if(userId==null){
            throw new BadRequestException("User id cannot be null.");
        }
        userRepository.findById(userId).orElseThrow(()->new NotFoundException("User not found."));
        bookingRepository.findByUserId(userId).orElseThrow(()->new NotFoundException("Booking not found."));
        bookingRepository.deleteByUser_Id(userId);
    }
}
