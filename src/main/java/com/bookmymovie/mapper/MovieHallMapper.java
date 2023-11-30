package com.bookmymovie.mapper;

import com.bookmymovie.dto.MovieHallDTO;
import com.bookmymovie.entity.MovieHall;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface MovieHallMapper {

    MovieHallMapper INSTANCE = Mappers.getMapper(MovieHallMapper.class);

    MovieHallDTO movieHallToMovieHallDTO(MovieHall movieHall);
//    MovieHall movieHallDTOToMovieHall(MovieHallDTO movieHallDTO);
    List<MovieHallDTO> toMovieHallDTOs(List<MovieHall> movieHalls);
}
