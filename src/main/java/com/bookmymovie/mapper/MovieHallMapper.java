package com.bookmymovie.mapper;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface MovieHallMapper {


    MovieHallDTO movieHallToMovieHallDTO(MovieHall movieHall);
//    MovieHall movieHallDTOToMovieHall(MovieHallDTO movieHallDTO);
    List<MovieHallDTO> toMovieHallDTOs(List<MovieHall> movieHalls);
}
