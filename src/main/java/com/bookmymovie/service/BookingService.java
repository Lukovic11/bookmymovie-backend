package com.bookmymovie.service;

import com.bookmymovie.dto.BookingDTO;
import com.bookmymovie.entity.Booking;

import java.util.List;

public interface BookingService {

    List<BookingDTO> findAll();

    List<BookingDTO> findByUserId(Long userId);

    List<BookingDTO> findByScreening_Id(Long screeningId);

    void save(Booking booking);

    void deleteById(Long id);

    void deleteByScreening_Id(Long screeningId);

    void deleteByUser_Id(Long userId);

}
