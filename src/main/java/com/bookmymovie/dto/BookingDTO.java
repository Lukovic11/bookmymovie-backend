package com.bookmymovie.dto;

import com.bookmymovie.entity.Movie;
import com.bookmymovie.entity.Screening;
import com.bookmymovie.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;
    private Long numOfSeats;
    private Date createdOn;
    private Screening screening;
    private User user;
    private Movie movie;
}
