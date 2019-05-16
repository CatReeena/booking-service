package com.shera.booking;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter @Setter
@RedisHash("BookingRequest")
public class BookingRequest implements Serializable {
    private Long id;
    private Long phoneNumber;
    private Long seatId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate eventDate;


    @Override
    public String toString() {
        return "BookingRequest{" +
                "phoneNumber=" + phoneNumber +
                ", seatId=" + seatId +
                ", eventDate=" + eventDate +
                '}';
    }
}
