package com.bookmymovie.rest;

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
    @GetMapping("/bySeatIds/{seatIds}")
    public List<SeatDTO> findByIdIn(@PathVariable List<Long> seatIds) {
        return seatService.findByIdIn(seatIds);
    }

    @DeleteMapping("byMovieHallId/{movieHallId}")
    public void deleteByMovieHall_Id(@PathVariable Long movieHallId) {
        seatService.deleteByMovieHall_Id(movieHallId);
    }


//    DON'T DELETE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    a method for creating the seats in the database for all the movie halls
//    @PostMapping("/createSeats")
//    public void saveSeatsInDatabase(){
//        List<MovieHallDTO> movieHalls = movieHallService.findAll();
//        for(MovieHallDTO mh:movieHalls){
//            Long rowNumber=1l;
//            Long seatNumber=1l;
//            for (Long i=0l;i<mh.getNumOfSeats();i++){
//            Seat seat = new Seat();
//            seat.setMovieHall(movieHallMapper.movieHallDTOToMovieHall(mh));
//                switch (mh.getNumOfSeats().intValue()){
//                    case 50:
//                        if(seatNumber==11){
//                            rowNumber++;
//                            seatNumber=1l;
//                        }
//                        break;
//                    case 100, 200:
//                        if(seatNumber==21){
//                            rowNumber++;
//                            seatNumber=1l;
//                        }
//                        break;
//                    case 150:
//                        if(seatNumber==16){
//                            rowNumber++;
//                            seatNumber=1l;
//                        }
//                        break;
//                }
//                seat.setSeatNumber(seatNumber);
//                seat.setSeatRow(rowNumber);
//                seatNumber++;
//                seatService.save(seat);
//            }
//        }
//    }

}
