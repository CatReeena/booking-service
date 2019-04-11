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
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seatId;
    private Long phoneNumber;
    private Date eventDate;

    public Ticket(){}

    public Ticket(Seat seatId, Long phoneNumber) {
        this.seatId = seatId;
        this.phoneNumber = phoneNumber;
    }
}
