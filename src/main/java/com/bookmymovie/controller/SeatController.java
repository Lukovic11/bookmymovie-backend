package com.bookmymovie.controller;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.dto.SeatDTO;
import com.bookmymovie.entity.Seat;
import com.bookmymovie.mapper.MovieHallMapper;
import com.bookmymovie.service.MovieHallService;
import com.bookmymovie.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
@Transactional
public class SeatController {

    @Autowired
    private SeatService seatService;

    @Autowired
    MovieHallService movieHallService;
    @Autowired
    MovieHallMapper movieHallMapper;

    @GetMapping("/{id}")
    public SeatDTO findById(@PathVariable Long id) {
        return seatService.findById(id);
    }

    @GetMapping("/byMovieHall/{id}")
    public List<SeatDTO> findByMovieHallId(@PathVariable Long id) {
        return seatService.findByMovieHallId(id);
    }

    @DeleteMapping("byMovieHallId/{movieHallId}")
    public void deleteByMovieHall_Id(@PathVariable Long movieHallId) {
        seatService.deleteByMovieHall_Id(movieHallId);
    }


    //    a method for creating the seats in the database for all the movie halls
    @PostMapping("/createSeats")
    public void saveSeatsInDatabase(){
        List<MovieHallDTO> movieHalls = movieHallService.findAll();
        for(MovieHallDTO mh:movieHalls){
            Long rowNumber= 1L;
            Long seatNumber= 1L;
            for (Long i = 0L; i<mh.getNumOfSeats(); i++){
                Seat seat = new Seat();
                seat.setMovieHall(movieHallMapper.movieHallDTOToMovieHall(mh));
                switch (mh.getNumOfSeats().intValue()){
                    case 50,100:
                        if(seatNumber==11){
                            rowNumber++;
                            seatNumber= 1L;
                        }
                        break;
                    case 200:
                        if(seatNumber==21){
                            rowNumber++;
                            seatNumber= 1L;
                        }
                        break;
                    case 150:
                        if(seatNumber==16){
                            rowNumber++;
                            seatNumber= 1L;
                        }
                        break;
                }
                seat.setSeatNumber(seatNumber);
                seat.setSeatRow(rowNumber);
                seatNumber++;
                seatService.save(seat);
            }
        }
    }

}
