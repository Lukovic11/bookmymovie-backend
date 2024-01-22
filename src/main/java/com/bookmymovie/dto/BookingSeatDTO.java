package com.bookmymovie.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingSeatDTO {

    private Long id;
    private Long bookingId;
    private Long seatId;
}
