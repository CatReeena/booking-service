package com.shera.booking.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Seat implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(mappedBy = "seat")
    private Ticket ticket;

    public Seat(){}

}
