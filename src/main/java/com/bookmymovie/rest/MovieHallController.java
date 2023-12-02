package com.bookmymovie.rest;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieHalls")
public class MovieHallController {

    MovieHallService movieHallService;

    @Autowired
    public MovieHallController(MovieHallService movieHallService) {
        this.movieHallService = movieHallService;
    }

    @GetMapping()
    @Transactional
    public List<MovieHallDTO> findAll(){
        return movieHallService.findAll();
    }

    @PostMapping
    @Transactional
    public void save(@RequestBody MovieHall movieHall) {
        movieHallService.save(movieHall);
    }

    @DeleteMapping("/deleteById/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        movieHallService.deleteById(id);
    }

}
