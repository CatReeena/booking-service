package com.shera.booking.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Ticket implements Serializable {
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
