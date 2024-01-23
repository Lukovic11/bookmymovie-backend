package com.bookmymovie.mapper;

import com.bookmymovie.dto.BookedSeatDTO;
import com.bookmymovie.entity.BookedSeat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookedSeatMapper {

    BookedSeatDTO bookingSeatToBookingSeatDTO(BookedSeat bookedSeat);
    BookedSeat bookingSeatDTOToBookingSeat(BookedSeatDTO bookedSeatDTO);
    List<BookedSeatDTO> toBookingSeatDTOs(List<BookedSeat> bookedSeats);
}
