package com.bookmymovie.mapper;

import com.bookmymovie.dto.SeatDTO;
import com.bookmymovie.entity.Seat;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface SeatMapper {


    SeatDTO seatToSeatDTO(Seat seat);
    List<SeatDTO> toSeatDTOs(List<Seat> seats);
}
