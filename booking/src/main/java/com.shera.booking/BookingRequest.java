package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class BookingRequest {
    private Long phoneNumber;
    private Long seatId;
    private LocalDate eventDate;
}
