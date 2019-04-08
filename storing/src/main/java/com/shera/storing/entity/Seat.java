package com.shera.storing.entity;

import com.shera.storing.entity.Booking;
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

//    public Seat(Long id){
//        this.id = id;
//    }
}
