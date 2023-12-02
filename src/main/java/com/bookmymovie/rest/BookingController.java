package com.bookmymovie.rest;

import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping()
    @Transactional
    public List<BookingDTO> findAll(){
        return bookingService.findAll();
    }

    @GetMapping("/byUserId/{userId}")
    @Transactional
    public List<BookingDTO> findByUserId(@PathVariable Long userId) {
        return bookingService.findByUserId(userId);
    }

    @PutMapping
    @Transactional
    public void save(@RequestBody Booking booking) {
        bookingService.save(booking);
    }

    @DeleteMapping("/byId/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        bookingService.deleteById(id);
    }

    @DeleteMapping("/byMovieId/{movieId}")
    @Transactional
    public void deleteByMovieId(@PathVariable Long movieId) {
        bookingService.deleteByMovieId(movieId);
    }
    @DeleteMapping("/byUserId/{userId}")
    @Transactional
    public void deleteByUser_Id(@PathVariable Long userId) {
        bookingService.deleteByUser_Id(userId);
    }

}
