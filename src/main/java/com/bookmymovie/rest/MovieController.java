package com.bookmymovie.rest;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private MovieMapper movieMapper;
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @GetMapping()
    @Transactional
    public List<MovieDTO> findAll(){
        return movieService.findAll();
    }

    @GetMapping("/byGenre/{genre}")
    @Transactional
    public List<Movie> findByGenre(@PathVariable String genre) {
        return movieService.findByGenre(genre);
    }

    @GetMapping("/byTitle/{title}")
    @Transactional
    public List<Movie> findByTitle(@PathVariable String title) {
        return movieService.findByTitle(title);
    }


    public void save(@RequestBody Movie movie) {
        movieService.save(movie);
    }

    @PostMapping()
    @Transactional
    public void handleFileUpload(                  @RequestParam("title") String title,
                                                   @RequestParam("description") String description,
                                                   @RequestParam("yearOfRelease") Long yearOfRelease,
                                                   @RequestParam("duration") Long duration,
                                                   @RequestParam("language") String language,
                                                   @RequestParam("countryOfOrigin") String countryOfOrigin,
                                                   @RequestParam("director") String director,
                                                   @RequestParam("genre") String genre,
                                                   @RequestParam("poster") MultipartFile file,
                                                   @RequestParam("trailer") String trailer) {
        try {
            // Validate file content and other parameters if needed
            // ...

            // Convert the file content to a byte array
            byte[] poster = file.getBytes();
            Movie movie=new Movie();
            movie.setTitle(title);
            movie.setDescription(description);
            movie.setYearOfRelease(yearOfRelease);
            movie.setDuration(duration);
            movie.setLanguage(language);
            movie.setCountryOfOrigin(countryOfOrigin);
            movie.setDirector(director);
            movie.setGenre(genre);
            movie.setPoster(poster);
            movie.setTrailer(trailer);

            save(movie);

            // Save the data to the database (replace this with your database logic)
            // ...

        } catch (Exception e) {
        }
    }

    @DeleteMapping("/deleteById/{id}")
    @Transactional
    public void deleteById(@PathVariable Long id) {
        movieService.deleteById(id);
    }

}
