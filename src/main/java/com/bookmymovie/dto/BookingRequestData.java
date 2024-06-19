package com.bookmymovie.dto;

import com.bookmymovie.entity.Booking;
import lombok.Data;

@Data
public class BookingRequestData {

    private Booking booking;
    private EmailData emailData;


}
