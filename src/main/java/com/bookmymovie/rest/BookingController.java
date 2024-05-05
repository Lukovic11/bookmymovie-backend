package com.bookmymovie.rest;

import com.bookmymovie.dto.BookedSeatDTO;
import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.BookedSeat;
import com.bookmymovie.entity.Booking;
import com.bookmymovie.mapper.BookedSeatMapper;
import com.bookmymovie.service.BookedSeatService;
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
    private BookedSeatService bookedSeatService;
    @Autowired
    private BookedSeatMapper bookedSeatMapper;

    @GetMapping()
    public List<BookingDTO> findAll(){
        List<BookingDTO> bookings = bookingService.findAll();
        setSeatsToBookings(bookings);
        return bookings;
    }

    @GetMapping("/byUserId/{userId}")
    public List<BookingDTO> findByUserId(@PathVariable Long userId) {
        List<BookingDTO> bookings = bookingService.findByUserId(userId);
        setSeatsToBookings(bookings);
        return bookings;
    }


    @GetMapping("byScreeningId/{screeningId}")
    public List<BookingDTO> findByScreening_Id(@PathVariable Long screeningId) {
        List<BookingDTO> bookings = bookingService.findByScreening_Id(screeningId);
        setSeatsToBookings(bookings);
        return bookings;
    }

    @PostMapping()
    public void save(@RequestBody Booking booking) {
        bookingService.save(booking);
        for(Long s:booking.getSeats()){
            BookedSeat bookedSeat =new BookedSeat();
            bookedSeat.setBookingId(booking.getId());
            bookedSeat.setSeatId(s);
            bookedSeatService.save(bookedSeat);
        }
    }

    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id) {
        bookingService.deleteById(id);
    }


    @DeleteMapping("/byUserId/{userId}")
    public void deleteByUser_Id(@PathVariable Long userId) {
        bookingService.deleteByUser_Id(userId);
    }

    @DeleteMapping("byScreeningId/{screeningId}")
    public void deleteByScreening_Id(@PathVariable Long screeningId) {
        bookingService.deleteByScreening_Id(screeningId);
    }

    private void setSeatsToBookings(List<BookingDTO> bookings) {
        for(BookingDTO b:bookings){
            List<BookedSeatDTO> bookedSeats=bookedSeatMapper.toBookingSeatDTOs(bookedSeatService.findByBookingId(b.getId()));
            for(BookedSeatDTO bs:bookedSeats){
                Long seat=bs.getSeatId();
                b.getSeats().add(seat);
            }
        }
    }
}
