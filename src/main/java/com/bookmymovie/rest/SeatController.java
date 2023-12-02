package com.bookmymovie.rest;

import com.bookmymovie.dto.SeatDTO;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/byScreeningId/{screeningId}")
    @Transactional
    public List<SeatDTO> findByScreeningId(@PathVariable Long screeningId) {
        return seatService.findByScreeningId(screeningId);
    }

    @GetMapping("/byReservedAndScreenigId/{reserved}/{screeningId}")
    @Transactional
    public List<SeatDTO> findByReservedAndScreeningId(@PathVariable boolean reserved, @PathVariable Long screeningId) {
        return seatService.findByReservedAndScreeningId(reserved,screeningId);
    }

    @GetMapping("/bySeatIds/{seatIds}")
    @Transactional
    public List<SeatDTO> findByIdIn(@PathVariable List<Long> seatIds) {
        return seatService.findByIdIn(seatIds);
    }

    @PutMapping("/bySeatAvailability/{seatIds}/{reserved}")
    @Transactional
    public void updateSeatAvailability(@PathVariable List<Long> seatIds,@PathVariable boolean reserved) {
        seatService.updateSeatAvailability(seatIds,reserved);
    }

}
