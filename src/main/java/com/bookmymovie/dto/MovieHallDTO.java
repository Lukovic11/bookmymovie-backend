package com.bookmymovie.dto;

import com.bookmymovie.entity.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieHallDTO {

    private Long id;
    private String name;
    private Long numOfSeats;

}
