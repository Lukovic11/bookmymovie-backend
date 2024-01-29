package com.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookedSeatDTO {

    private Long id;
    private Long bookingId;
    private Long seatId;
}
