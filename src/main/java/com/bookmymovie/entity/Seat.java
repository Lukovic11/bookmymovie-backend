package com.bookmymovie.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "seat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "seatnumber")
    private Long seatNumber;

    @Column(name = "seatrow")
    private Long seatRow;

    @ManyToOne
    @JoinColumn(name = "idmoviehall", foreignKey = @ForeignKey(name = "moviehallfk2"),nullable = false)
    private MovieHall movieHall;


}
