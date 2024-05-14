package com.bookmymovie.repository;

import com.bookmymovie.entity.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {

    Optional<List<BookedSeat>> findByBookingId(Long bookingId);

    Optional<List<BookedSeat>> findBySeatId(Long seatId);

}
