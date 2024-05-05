package com.bookmymovie.mapper;

import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring")
public interface BookingMapper {

    List<BookingDTO> toBookingDTOs(List<Booking> bookings);

}
