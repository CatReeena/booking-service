package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ReadingService {

    @Autowired
    public final SeatDAO seatDAO;

    public Iterable<Seat> readBooking(LocalDate eventDate){
        return seatDAO.findAllByTicket_EventDate(eventDate);
    }
}
