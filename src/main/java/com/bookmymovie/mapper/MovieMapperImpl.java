package com.bookmymovie.mapper;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMapperImpl implements MovieMapper{
    @Override
    public MovieDTO movieToMovieDTO(Movie movie) {
        return new MovieDTO(movie.getId(),
                movie.getTitle(),
                movie.getDescription(),
                movie.getYearOfRelease(),
                movie.getDuration(),
                movie.getLanguage(),
                movie.getCountryOfOrigin(),
                movie.getDirector(),
                movie.getGenre(),
                movie.getPoster(),
                movie.getTrailer());
    }


    @Override
    public List<MovieDTO> toMovieDTOs(List<Movie> movies) {
        List<MovieDTO> movieDTOs = new ArrayList<>();
        for(Movie m:movies){
            movieDTOs.add(movieToMovieDTO(m));
        }
        return movieDTOs;
    }
}
