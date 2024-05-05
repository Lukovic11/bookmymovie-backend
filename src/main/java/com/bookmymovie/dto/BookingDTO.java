package com.bookmymovie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;
    private Long numOfSeats;
    private Date createdOn;
    private ScreeningDTO screening;
    private UserDTO user;
    private List<Long> seats=new ArrayList<>();
}
