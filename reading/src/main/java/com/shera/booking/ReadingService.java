package com.shera.booking;

import com.shera.booking.dao.SeatDAO;
import com.shera.booking.entity.Seat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;

@Service
@AllArgsConstructor
public class ReadingService {

    @Autowired
    public final SeatDAO seatDAO;


    public Iterable<Seat> readBooking(LocalDate eventDate){
//        seatDAO.save(new Seat());
//        Iterable<Seat> fgg = seatDAO.findAll();
//        Iterable<Seat> fg = seatDAO.findAllByTicket_EventDate(eventDate);
        return seatDAO.findAllByTicket_EventDate(eventDate);
    }
}
