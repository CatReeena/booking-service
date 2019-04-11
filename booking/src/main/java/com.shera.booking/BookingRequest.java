package com.shera.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
public class BookingRequest implements Serializable {
    private Long phoneNumber;
    private Long seatId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date eventDate;


    @Override
    public String toString() {
        return "BookingRequest{" +
                "phoneNumber=" + phoneNumber +
                ", seatId=" + seatId +
                ", eventDate=" + eventDate +
                '}';
    }
}
