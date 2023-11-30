package com.bookmymovie.dto;

import com.bookmymovie.entity.Booking;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class UserDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
}
