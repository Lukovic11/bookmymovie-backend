package com.bookmymovie.controller;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movieHalls")
@Transactional
public class MovieHallController {

    @Autowired
    MovieHallService movieHallService;

    @GetMapping()
    public List<MovieHallDTO> findAll(){
        return movieHallService.findAll();
    }

    @PostMapping
    public void save(@RequestBody MovieHall movieHall) {
        movieHallService.save(movieHall);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieHallService.deleteById(id);
    }




}
