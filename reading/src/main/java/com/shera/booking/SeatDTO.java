package com.shera.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Setter
public class SeatDTO implements Serializable {

    private Long seatId;
    private Long phoneNumber;
    private Boolean taken;


}
