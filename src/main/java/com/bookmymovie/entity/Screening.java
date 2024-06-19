package com.bookmymovie.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "screening")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @JsonProperty("movie")
    @ManyToOne
    @JoinColumn(name = "idmovie", foreignKey = @ForeignKey(name = "moviefk"))
    private Movie movie;

    @JsonProperty("movieHall")
    @ManyToOne
    @JoinColumn(name="idmoviehall", foreignKey = @ForeignKey(name = "moviehallfk"))
    private MovieHall movieHall;
}
