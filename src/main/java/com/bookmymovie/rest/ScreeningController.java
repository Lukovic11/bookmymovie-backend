package com.bookmymovie.rest;

import com.bookmymovie.dao.MovieHallRepository;
import com.bookmymovie.dao.MovieRepository;
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
import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    @Autowired
    private ScreeningService screeningService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieHallRepository movieHallRepository;

    @GetMapping()
    @Transactional
    public List<ScreeningDTO> findAll(){
        return screeningService.findAll();
    }

    @GetMapping("/byDate/{date}")
    @Transactional
    public List<ScreeningDTO> findByDate(@PathVariable LocalDate date) {
        return screeningService.findByDate(date);
    }

    @GetMapping("/byMovieId/{movieId}")
    @Transactional
    public List<ScreeningDTO> findByMovieId(@PathVariable Long movieId) {
        return screeningService.findByMovieId(movieId);
    }

    @PostMapping
    @Transactional
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
    @Transactional
    public void deleteById(@PathVariable Long id) {
        screeningService.deleteById(id);
    }

    @DeleteMapping("/byMovieId/{movieId}")
    @Transactional
    public void deleteByMovieId(@PathVariable Long movieId) {
        screeningService.deleteByMovieId(movieId);
    }

    @DeleteMapping("/byMovieHallId/{movieHallId}")
    @Transactional
    public void deleteByMovieHallId(@PathVariable Long movieHallId) {
        screeningService.deleteByMovieHallId(movieHallId);
    }

    @DeleteMapping("/byDate/{date}")
    @Transactional
    public void deleteByDate(@PathVariable LocalDate date) {
        screeningService.deleteByDate(date);
    }
}
