package com.bookmymovie.rest;

import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.entity.BookingSeat;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.service.BookingSeatService;
import com.bookmymovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@Transactional
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @Autowired
    private BookingSeatService bookingSeatService;

    @GetMapping()
    public List<BookingDTO> findAll(){
        return bookingService.findAll();
    }

    @GetMapping("/byUserId/{userId}")
    public List<BookingDTO> findByUserId(@PathVariable Long userId) {
        return bookingService.findByUserId(userId);
    }

    @PostMapping
    public void save(@RequestBody Booking booking) {
        bookingService.save(booking);
        for(Seat s:booking.getSeats()){
            BookingSeat bookingSeat=new BookingSeat();
            bookingSeat.setBookingId(booking.getId());
            bookingSeat.setSeatId(s.getId());
            bookingSeatService.save(bookingSeat);
        }
    }

    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id) {
        bookingService.deleteById(id);
    }

    @DeleteMapping("byScreeningId/{screeningId}")
    public void deleteByScreening_Id(@PathVariable Long screeningId) {
        bookingService.deleteByScreening_Id(screeningId);
    }

    @DeleteMapping("/byUserId/{userId}")
    public void deleteByUser_Id(@PathVariable Long userId) {
        bookingService.deleteByUser_Id(userId);
    }

}
