package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booked_seat")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "idbooking")
    private Long bookingId;

    @Column(name = "idseat")
    private Long seatId;


}
