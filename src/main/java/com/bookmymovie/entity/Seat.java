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

    @Column(name = "reserved")
    private Boolean reserved;

    @ManyToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "screeningfk"),nullable = false,insertable = false,updatable = false)
    private Screening screening;

    @ManyToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "moviehallfk2"),nullable = false,insertable = false,updatable = false)
    private MovieHall movieHall;


}
