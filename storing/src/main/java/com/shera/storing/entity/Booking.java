package com.shera.storing.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

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

    public Booking(){}

    public Booking(Seat seatId, Integer phoneNumber) {
        this.seatId = seatId;
        this.phoneNumber = phoneNumber;
    }
}
