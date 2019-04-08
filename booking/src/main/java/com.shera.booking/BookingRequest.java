package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookingRequest {
    private Integer phoneNumber;
    private Long seat;
}
