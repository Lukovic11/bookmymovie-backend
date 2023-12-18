package com.bookmymovie.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numofseats")
    private Long numOfSeats;

    @Column(name = "createdon")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "idscreening", foreignKey = @ForeignKey(name = "screeningfk2"),nullable = false,insertable = false,updatable = false)
    private Screening screening;


    @ManyToOne
    @JoinColumn(name = "iduser", foreignKey = @ForeignKey(name = "userfk"),insertable = false,updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idmovie", foreignKey = @ForeignKey(name = "moviefk2"),nullable = false,insertable = false,updatable = false)
    private Movie movie;



}
