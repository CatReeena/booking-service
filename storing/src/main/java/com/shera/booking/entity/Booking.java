package com.shera.booking.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seatId;
    private Integer phoneNumber;
    private LocalDate eventDate;

    public Booking(){}

    public Booking(Seat seatId, Integer phoneNumber) {
        this.seatId = seatId;
        this.phoneNumber = phoneNumber;
    }
}
