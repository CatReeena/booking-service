package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Getter
@Setter
public class SeatDTO {

    private Long seatId;
    private Long phoneNumber;
    private Boolean taken;


}
