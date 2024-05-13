package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.MovieRepository;
import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieDTO> findAll() {
        return movieMapper.toMovieDTOs(movieRepository.findAll());
    }

    @Override
    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie!=null){
            return movieMapper.movieToMovieDTO(movieRepository.findById(id).orElseThrow(NoSuchElementException::new));

        }
        return null;
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        return movieMapper.toMovieDTOs(movieRepository.findByGenre(genre));
    }

    @Override
    public MovieDTO findByTitle(String title) {
        return movieMapper.movieToMovieDTO(movieRepository.findByTitle(title));
    }


    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void update(List<Movie> movies) {
        for(Movie movie:movies){
            Movie old=movieRepository.findById(movie.getId()).orElseThrow();
            movie.setDescription(old.getDescription());
            movie.setYearOfRelease(old.getYearOfRelease());
            movie.setDuration(old.getDuration());
            movie.setTrailer(old.getTrailer());
            movieRepository.save(movie);
        }
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }
}
