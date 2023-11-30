package com.bookmymovie.dto;

import com.bookmymovie.entity.MovieHall;
import com.bookmymovie.entity.Screening;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

    private Long id;
    private Long seatNumber;
    private Long seatRow;
    private Boolean reserved;
    private Screening screening;
    private MovieHall movieHall;
}
