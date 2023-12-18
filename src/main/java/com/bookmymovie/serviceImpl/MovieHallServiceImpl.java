package com.bookmymovie.serviceImpl;

import com.bookmymovie.repository.MovieHallRepository;
import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.mapper.MovieHallMapper;
import com.bookmymovie.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieHallServiceImpl implements MovieHallService {

    @Autowired
    private MovieHallRepository movieHallRepository;
    @Autowired
    private MovieHallMapper movieHallMapper;

    @Override
    public List<MovieHallDTO> findAll() {
        List<MovieHallDTO> movieHalls= movieHallMapper.toMovieHallDTOs(movieHallRepository.findAll());
        return movieHalls;
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
