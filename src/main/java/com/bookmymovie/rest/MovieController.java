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

    // No post mapping because it is not meant to handle HTTP request but only to save the object.
    // Method for handling the HTTP request is handleFileUpload.
    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PostMapping()
    public void handleFileUpload(                  @RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("yearOfRelease") Long yearOfRelease,
                                                   @RequestParam("duration") Long duration,
                                                   @RequestParam("language") String language,
                                                   @RequestParam("countryOfOrigin") String countryOfOrigin,
                                                   @RequestParam("director") String director,
                                                   @RequestParam("genre") String genre,
                                                   @RequestParam("poster") String poster,
                                                   @RequestParam("trailer") String trailer) {
        try {

            MovieDTO existingMovie=movieService.findByTitle(title);

            if(existingMovie!=null){
                existingMovie.setPoster(poster);
                existingMovie.setDescription(description);
                existingMovie.setYearOfRelease(yearOfRelease);
                existingMovie.setDuration(duration);
                existingMovie.setLanguage(language);
                existingMovie.setCountryOfOrigin(countryOfOrigin);
                existingMovie.setDirector(director);
                existingMovie.setGenre(genre);
                existingMovie.setTrailer(trailer);

                save(movieMapper.movieDTOToMovie(existingMovie));
            }else{
                Movie movie=new Movie();
               // existingMovie.setPoster(poster);
                movie.setTitle(title);
                movie.setDescription(description);
                movie.setYearOfRelease(yearOfRelease);
                movie.setDuration(duration);
                movie.setLanguage(language);
                movie.setCountryOfOrigin(countryOfOrigin);
                movie.setDirector(director);
                movie.setGenre(genre);
                movie.setTrailer(trailer);

                save(movie);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

}
