package com.bookmymovie.rest;


import com.bookmymovie.entity.BookedSeat;
import com.bookmymovie.service.BookedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/bookedSeats")
@Transactional
public class BookedSeatController {

    @Autowired
    private BookedSeatService bookedSeatService;

    @GetMapping("byBookingId/{bookingId}")
    public List<BookedSeat> findByBookingId(@PathVariable Long bookingId) {
        return bookedSeatService.findByBookingId(bookingId);
    }

    @GetMapping("bySeatId/{seatId}")
    public List<BookedSeat> findBySeatId(@PathVariable Long seatId) {
        return bookedSeatService.findBySeatId(seatId);
    }


    @PostMapping
    public void save(BookedSeat bookedSeat) {
        bookedSeatService.save(bookedSeat);
    }

}
