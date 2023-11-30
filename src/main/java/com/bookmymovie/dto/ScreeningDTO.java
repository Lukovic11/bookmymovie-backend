package com.bookmymovie.dto;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.MovieHall;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreeningDTO {

    private Long id;
    private Long numOfAvailableSeats;
    private String type;
    private LocalDate date;
    private LocalTime time;
    private Movie movie;
    private MovieHall movieHall;
}
