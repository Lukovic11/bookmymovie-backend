package com.bookmymovie.dao;

import com.bookmymovie.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {

    List<Seat> findByScreening_Id(Long screeningId);
    List<Seat> findByReservedAndScreening_Id(boolean reserved, Long screeningId);
    List<Seat> findByIdIn(List<Long> seatIds);
    @Modifying
    @Query("UPDATE Seat s SET s.reserved=:reserved WHERE s.id IN :seatIds")
    void updateSeatAvailability(@Param("seatIds") List<Long> seatIds,@Param("reserved") boolean reserved);

}
