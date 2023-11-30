package com.bookmymovie.serviceImpl;

import com.bookmymovie.dao.MovieHallRepository;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallServiceImpl implements MovieHallService {

    private MovieHallRepository movieHallRepository;

    @Autowired
    public MovieHallServiceImpl(MovieHallRepository movieHallRepository) {
        this.movieHallRepository = movieHallRepository;
    }

    @Override
    public List<MovieHall> findAll() {
        return movieHallRepository.findAll();
    }

    @Override
    public void save(MovieHall movieHall) {
        movieHallRepository.save(movieHall);
    }

    @Override
    public void deleteById(Long id) {
        movieHallRepository.deleteById(id);
    }


}
