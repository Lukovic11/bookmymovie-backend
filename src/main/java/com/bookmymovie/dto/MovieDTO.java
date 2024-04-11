package com.bookmymovie.dto;

import com.bookmymovie.entity.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String title;
    private String description;
    private Long yearOfRelease;
    private Long duration;
    private String language;
    private String countryOfOrigin;
    private String director;
    private String genre;
    private byte[] poster;
    private String trailer;
    private Boolean isPlaying;

}
