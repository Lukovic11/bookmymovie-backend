package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "moviehall")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "numofseats")
    private Long numOfSeats;


}
