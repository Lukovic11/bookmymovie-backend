package com.bookmymovie.rest;

import com.bookmymovie.repository.MovieHallRepository;
import com.bookmymovie.repository.MovieRepository;
import com.bookmymovie.dto.ScreeningDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.service.ScreeningService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/screenings")
@Transactional
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;

    @GetMapping()
    public List<ScreeningDTO> findAll(){
        return screeningService.findAll();
    }

    @GetMapping("/{date}/{time}/{movieId}")
    ScreeningDTO findByDateAndTime(@PathVariable LocalDate date, @PathVariable LocalTime time, @PathVariable Long movieId) {
        return screeningService.findByDateAndTimeAndMovie_Id(date,time,movieId);
    }

    @GetMapping("/byMovieId/{movieId}")
    public List<ScreeningDTO> findByMovieId(@PathVariable Long movieId) {
        return screeningService.findByMovieId(movieId);
    }

    @PostMapping
    public void save(@RequestBody Screening screening) {
        Movie movie=movieRepository.findById(screening.getMovie().getId())
                .orElseThrow(()->new EntityNotFoundException("Movie not found with id:" + screening.getMovie().getId()));
        MovieHall movieHall=movieHallRepository.findById(screening.getMovieHall().getId())
                .orElseThrow(()->new EntityNotFoundException("Movie Hall not found with id:" + screening.getMovieHall().getId()));
        screening.setMovie(movie);
        screening.setMovieHall(movieHall);
        screeningService.save(screening);
    }

    @DeleteMapping("/byId/{id}")
    public void deleteById(@PathVariable Long id) {
        screeningService.deleteById(id);
    }

    @DeleteMapping("/byMovieId/{movieId}")
    public void deleteByMovieId(@PathVariable Long movieId) {
        screeningService.deleteByMovieId(movieId);
    }

    @DeleteMapping("/byMovieHallId/{movieHallId}")
    public void deleteByMovieHallId(@PathVariable Long movieHallId) {
        screeningService.deleteByMovieHallId(movieHallId);
    }

    @DeleteMapping("/byDate/{date}")
    public void deleteByDate(@PathVariable LocalDate date) {
        screeningService.deleteByDate(date);
    }

    @PostMapping("/makeScreenings")
    public void generateScreeningsForNext3Months() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusMonths(3);
        List<Movie> movies = movieRepository.findByIsPlayingTrue();
        List<MovieHall> movieHalls = movieHallRepository.findAll();

        LocalTime[] timeSlots = {LocalTime.of(15, 0), LocalTime.of(18, 0), LocalTime.of(21, 0)};
        int timeSlotIndex = 0;

        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)) {
            for (Movie movie : movies) {
                if (!screeningService.existsByMovieAndDate(movie, date)) {
                    MovieHall movieHall = movieHalls.get((int) (Math.random() * movieHalls.size()));
                    for (LocalTime time : timeSlots) {
                        Screening screening = new Screening();
                        screening.setMovie(movie);
                        screening.setMovieHall(movieHall);
                        screening.setDate(date);
                        screening.setTime(time);
                        screeningService.save(screening);
                    }
                }
            }
        }
    }
}




