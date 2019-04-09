package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class BookingRequest {
    private Integer phoneNumber;
    private Long seat;
    private Date eventDate;
}
