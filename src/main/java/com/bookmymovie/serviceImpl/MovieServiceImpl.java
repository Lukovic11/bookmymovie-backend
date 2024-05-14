package com.bookmymovie.serviceImpl;

import com.bookmymovie.exceptions.BadRequestException;
import com.bookmymovie.exceptions.NotFoundException;
import com.bookmymovie.exceptions.ValidationException;
import com.bookmymovie.repository.MovieRepository;
import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import com.bookmymovie.mapper.MovieMapper;
import com.bookmymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Date;
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
        if(id==null){
            throw new BadRequestException("Movie id cannot be null.");
        }
        return movieMapper.movieToMovieDTO(movieRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Movie with the id of "+id+" not found.")));
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        if(genre==null){
            throw new BadRequestException("Genre cannot be null.");
        }
        return movieMapper.toMovieDTOs(movieRepository.findByGenre(genre)
                .orElseThrow(()->new NotFoundException("Movies with the id of "+genre+" not found.")));
    }

    @Override
    public MovieDTO findByTitle(String title) {
        if(title==null){
            throw new BadRequestException("Title cannot be null.");
        }
        return movieMapper.movieToMovieDTO(movieRepository.findByTitle(title)
                .orElseThrow(()->new NotFoundException("Movie with the title of "+ title+ " not found.")));
    }


    @Override
    public void save(Movie movie) {
        if(movie.getTitle()==null || movie.getDescription()==null ||
        movie.getDirector()==null || movie.getPoster()==null ||
        movie.getTrailer()==null || movie.getCountryOfOrigin()==null ||
        movie.getLanguage()==null || movie.getGenre()==null ||
        movie.getYearOfRelease()==null || movie.getDuration()==null){
            throw new ValidationException("Fields cannot be null.");
        }
        if(movie.getYearOfRelease()<1906 || movie.getYearOfRelease()> (long) Year.now().getValue() ||
        movie.getDuration()<40){
            throw new ValidationException("Check year and duration constraints.");
        }
        movieRepository.save(movie);
    }

    @Override
    public void update(List<Movie> movies) {
        for(Movie movie:movies){
            if(movie.getId()==null){
                throw new BadRequestException("Movie id cannot be null.");
            }
            Movie old=movieRepository.findById(movie.getId())
                    .orElseThrow(()->new NotFoundException("Movie with the id of "+movie.getId()+" not found."));
            movie.setDescription(old.getDescription());
            movie.setYearOfRelease(old.getYearOfRelease());
            movie.setDuration(old.getDuration());
            movie.setTrailer(old.getTrailer());
            movieRepository.save(movie);
        }
    }

    @Override
    public void deleteById(Long id) {
        if(id==null){
            throw new BadRequestException("Movie id cannot be null.");
        }
        movieRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Movie with the id of "+id+" not found."));
        movieRepository.deleteById(id);
    }
}
