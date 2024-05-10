package com.bookmymovie.rest;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
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
        System.out.println(movie);
        movieService.save(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

}
