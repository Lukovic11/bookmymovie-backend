package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Column(name = "numofavailableseats")
    private Long numOfAvailableSeats;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "moviefk"),insertable = false,updatable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="id", foreignKey = @ForeignKey(name = "moviehallfk"),insertable = false,updatable = false)
    private MovieHall movieHall;


}
