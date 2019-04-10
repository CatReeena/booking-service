package com.shera.booking.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Getter
@Setter
public class Seat {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "seatId")
    private Ticket ticket;

    public Seat(){}

}
