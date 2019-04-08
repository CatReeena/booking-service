package com.shera.storing;

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
    private Booking booking;

    public Seat(){}
}
