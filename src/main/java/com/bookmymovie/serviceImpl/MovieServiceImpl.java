package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.MovieRepository;
import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieDTO> findAll() {
        List<MovieDTO> movies = movieMapper.toMovieDTOs(movieRepository.findAll());
        return movies;
    }

    @Override
    public MovieDTO findById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if(movie!=null){
            return movieMapper.movieToMovieDTO(movieRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));

        }
        return null;
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        List<MovieDTO> movies = movieMapper.toMovieDTOs(movieRepository.findByGenre(genre));
        return movies;
    }

    @Override
    public List<MovieDTO> findByTitle(String title) {
        List<MovieDTO> movies= movieMapper.toMovieDTOs(movieRepository.findByTitle(title));
        return movies;
    }


    @Override
    public void save(Movie movie) {
        //    save method is used for both saving and updating based on weather the entity has a defined id
        movieRepository.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }




}
