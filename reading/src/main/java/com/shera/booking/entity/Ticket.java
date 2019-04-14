package com.shera.booking.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
    private Long phoneNumber;
    private LocalDate eventDate;

    public Ticket(){}

    public Ticket(Seat seat, Long phoneNumber) {
        this.seat = seat;
        this.phoneNumber = phoneNumber;
    }
}
