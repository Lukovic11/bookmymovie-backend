package com.bookmymovie.controller;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
import com.bookmymovie.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Transactional
public class MovieController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private ScreeningService screeningService;

    @GetMapping()
    public List<MovieDTO> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return movieService.findById(id);
    }

    @GetMapping("/byGenre/{genre}")
    public List<MovieDTO> findByGenre(@PathVariable String genre) {
        return movieService.findByGenre(genre);
    }

    @GetMapping("/byTitle/{title}")
    public MovieDTO findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }

    @PostMapping()
    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PutMapping("/update")
    public void update(@RequestBody List<Movie> movies){
        screeningService.deleteAllInBatch();
        movieService.update(movies);
        screeningService.generateScreeningsForNext3Months();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

}
