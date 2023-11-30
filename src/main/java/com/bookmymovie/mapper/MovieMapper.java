package com.bookmymovie.mapper;

import com.bookmymovie.dto.MovieDTO;
import com.bookmymovie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO movieToMovieDTO(Movie movie);
//    Movie movieDTOToMovie(MovieDTO movieDTO);
    List<MovieDTO> toMovieDTOs(List<Movie> movies);
}
